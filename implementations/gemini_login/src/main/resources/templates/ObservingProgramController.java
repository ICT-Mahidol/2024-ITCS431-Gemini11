package th.ac.mahidol.ict.gemini_login.controller;
import edu.gemini.app.ocs.model.ObservingProgram;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import edu.gemini.app.ocs.example.MyObservingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini_login.service.ObservingProgramService;

@Controller
public class ObservingProgramController extends MyObservingProgram{

    @Autowired
    private ObservingProgramService service;

    @GetMapping("/observing-program-form")
    public String showForm(Model model) {
        model.addAttribute("program", new MyObservingProgram());
        return "observing-program";
    }




}
