package th.ac.mahidol.ict.gemini_login.controller;

import edu.gemini.app.ocs.example.MyObservingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini_login.service.ObservingProgramService;

@Controller
public class ObservingProgramController {

    @Autowired
    private ObservingProgramService service;

    @GetMapping("/observing-program-form")
    public String showForm(Model model) {
        model.addAttribute("program", new MyObservingProgram());
        return "observing-program";
    }

    @PostMapping("/observing-program")
    public String createProgram(@ModelAttribute MyObservingProgram program, Model model) {
        try {
            MyObservingProgram result = service.createObservingProgram(program);
            model.addAttribute("program", result);
            model.addAttribute("success", "Observing Program created successfully.");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create observing program: " + e.getMessage());
        }
        return "observing-program";
    }
}
