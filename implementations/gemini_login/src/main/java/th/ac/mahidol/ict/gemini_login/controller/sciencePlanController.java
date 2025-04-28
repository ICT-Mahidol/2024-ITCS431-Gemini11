package th.ac.mahidol.ict.gemini_login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;

@Controller
public class sciencePlanController {
    @GetMapping("/create-science-plan-form")
    public String CreateSciencePlanFormPage(Model model) {
        model.addAttribute("sciencePlan", new MySciencePlan());
        return "create-science-plan-form";
    }

    @PostMapping("/create-science-plan")
    public String handleCreateSciencePlan(@RequestParam Map<String, String> params, Model model, RedirectAttributes redirectAttributes) {
        try {
            // Parse all form data
            MySciencePlan sp = new MySciencePlan();
            sp.setPlanNo(Integer.parseInt(params.get("sciencePlanID")));
            sp.setCreator(params.get("sciencePlanCreator"));
            sp.setFundingInUSD(Double.parseDouble(params.get("sciencePlanFunding")));
            sp.setObjectives(params.get("sciencePlanObjective"));
            sp.setStarSystem(CONSTELLATIONS.valueOf(params.get("sciencePlanTarget")));

            SimpleDateFormat dateFormatted = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormatted.parse(params.get("sciencePlanStartDate"));
            Date endDate = dateFormatted.parse(params.get("sciencePlanEndDate"));

            if (startDate.after(endDate)) {
                model.addAttribute("error", "Start date cannot be after the end date.");
                return "create-science-plan-form";
            }
            sp.setStartDate(startDate);
            sp.setEndDate(endDate);

            String location = params.get("sciencePlanTelescope");
            if (location.equalsIgnoreCase("hawaii")) {
                sp.setTelescopeLocation(MySciencePlan.TELESCOPELOC.HAWAII);
            } else {
                sp.setTelescopeLocation(MySciencePlan.TELESCOPELOC.CHILE);
            }

            sp.setStarSystem(CONSTELLATIONS.valueOf(params.get("sciencePlanTarget")));

            DataProcRequirement dpr = new DataProcRequirement(
                    params.get("dataProcessRequirementFileType"),
                    params.get("dataProcessRequirementFileQuality"),
                    params.get("dataProcessRequirementColorType"),
                    parseDoubleSafe(params.get("dataProcessRequirementContrast")),
                    parseDoubleSafe(params.get("dataProcessRequirementExposure")),
                    parseDoubleSafe(params.get("dataProcessRequirementBrightness")),
                    parseDoubleSafe(params.get("dataProcessRequirementSaturation")),
                    parseDoubleSafe(params.get("dataProcessRequirementLuminance")),
                    parseDoubleSafe(params.get("dataProcessRequirementHue")),
                    parseDoubleSafe(params.get("dataProcessRequirementHighlights")),
                    parseDoubleSafe(params.get("dataProcessRequirementShadows")),
                    parseDoubleSafe(params.get("dataProcessRequirementWhites")),
                    parseDoubleSafe(params.get("dataProcessRequirementBlacks"))
            );

            sp.setDataProcRequirements(dpr);

            // Submit to OCS
            OCS ocs = new OCS(true);
            ocs.createSciencePlan(sp);

            // ✨ Save as JSON
            saveSciencePlanAsJson(sp);

            model.addAttribute("goode", "Science Plan created and saved successfully!");
            return "create-science-plan-form";
        } catch (Exception e) {
            e.printStackTrace(); // <-- ADD THIS LINE
            model.addAttribute("error", "Failed to create Science Plan: " + e.getMessage());
            return "create-science-plan-form";
        }
    }
    private void saveSciencePlanAsJson(MySciencePlan sp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); // ✨ important!

        String basePath = System.getProperty("user.dir");
        String folderPath = basePath + "/references/science_plan/";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filename = "science_plan_" + sp.getPlanNo() + ".json";
        File file = new File(folder, filename);

        System.out.println("Saving science plan JSON to: " + file.getAbsolutePath());
        System.out.println(basePath + " and " + folderPath);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, sp);
    }


    private double parseDoubleSafe(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(value);
    }
    @GetMapping("/science-plan-list")
    public String showSciencePlanList(Model model) {
        File folder = new File(System.getProperty("user.dir") + "/references/science_plan/");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

        List<MySciencePlan> sciencePlans = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                try {

                    Map<String, Object> map = objectMapper.readValue(file, Map.class);

                    MySciencePlan sp = new MySciencePlan();
                    sp.setPlanNo((Integer) map.get("planNo"));
                    sp.setCreator((String) map.get("creator"));
                    sp.setFundingInUSD((Double) map.get("fundingInUSD"));
                    sp.setObjectives((String) map.get("objectives"));
                    sp.setStarSystem(CONSTELLATIONS.valueOf((String) map.get("starSystem")));

                    sciencePlans.add(sp);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("sciencePlans", sciencePlans);
        return "science-plan-list";
    }




}
