package th.ac.mahidol.ict.gemini_login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini_login.model.MyObservingProgram;
import th.ac.mahidol.ict.gemini_login.service.ObservingProgramService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ObservingProgramController {

    @Autowired
    private ObservingProgramService service;

    @GetMapping("/observing-program-form")
    public String showObservingProgramForm(@RequestParam(value = "planNo", required = false) Integer planNo, Model model) {
        model.addAttribute("planNo", planNo);  // Pass planNo if editing
        return "observing-program";
    }

    @GetMapping("/observing-program-form-edit")
    public String showEditForm(@RequestParam(value = "planNo") int planNo, Model model) {
        model.addAttribute("planNo", planNo);
        return "observing-program-form-edit";
    }

    @PostMapping("/save-observing-program")
    @ResponseBody
    public String saveObservingProgram(@RequestBody MyObservingProgram program) {
        try {
            saveProgramAsJson(program);
            return "Success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed: " + e.getMessage();
        }
    }

    @GetMapping("/api/observing-program/{planNo}")
    @ResponseBody
    public MyObservingProgram getProgramByPlanNo(@PathVariable int planNo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(System.getProperty("user.dir") + "/references/observing_program/observing_program_" + planNo + ".json");
            if (file.exists()) {
                return mapper.readValue(file, MyObservingProgram.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/observing-program-list")
    public String showObservingProgramListPage() {
        return "observing-program-list";
    }

    @GetMapping("/observing-program-list-json")
    @ResponseBody
    public List<MyObservingProgram> getObservingProgramListJson() {
        List<MyObservingProgram> programList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        File folder = new File(System.getProperty("user.dir") + "/references/observing_program/");
        if (folder.exists()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
            if (files != null) {
                for (File file : files) {
                    try {
                        MyObservingProgram program = mapper.readValue(file, MyObservingProgram.class);
                        programList.add(program);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return programList;
    }

    private void saveProgramAsJson(MyObservingProgram program) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String folderPath = System.getProperty("user.dir") + "/references/observing_program/";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filename = "observing_program_" + program.getPlanNo() + ".json";
        File outputFile = new File(folder, filename);

        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, program);
    }

    @DeleteMapping("/delete-observing-program/{planNo}")
    @ResponseBody
    public String deleteObservingProgram(@PathVariable int planNo) {
        try {
            String folderPath = System.getProperty("user.dir") + "/references/observing_program/";
            File folder = new File(folderPath);

            // Step 1: Delete the selected plan
            File fileToDelete = new File(folderPath + "observing_program_" + planNo + ".json");
            if (fileToDelete.exists()) {
                fileToDelete.delete();
            } else {
                return "File not found.";
            }

            // Step 2: Load all remaining programs
            ObjectMapper mapper = new ObjectMapper();
            File[] files = folder.listFiles((dir, name) -> name.startsWith("observing_program_") && name.endsWith(".json"));
            if (files == null) return "No files found.";

            List<MyObservingProgram> programList = new ArrayList<>();
            for (File file : files) {
                MyObservingProgram prog = mapper.readValue(file, MyObservingProgram.class);
                programList.add(prog);
            }

            // Step 3: Sort by old planNo
            programList.sort(Comparator.comparingInt(MyObservingProgram::getPlanNo));

            // Step 4: Clear old JSON files
            for (File file : files) {
                file.delete();
            }

            // Step 5: Save back with new sequential plan numbers
            int newPlanNo = 1;
            for (MyObservingProgram prog : programList) {
                prog.setPlanNo(newPlanNo++);
                File newFile = new File(folderPath + "observing_program_" + prog.getPlanNo() + ".json");
                mapper.writerWithDefaultPrettyPrinter().writeValue(newFile, prog);
            }

            return "Deleted and Reorganized";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
