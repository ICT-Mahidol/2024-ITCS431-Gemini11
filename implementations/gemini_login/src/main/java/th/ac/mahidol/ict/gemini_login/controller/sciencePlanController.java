package th.ac.mahidol.ict.gemini_login.controller;

import edu.gemini.app.ocs.OCS;
import org.springframework.web.bind.annotation.GetMapping;
import edu.gemini.app.ocs.example.MySciencePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
            // parse all the data to science plan object
            MySciencePlan sp = new MySciencePlan();
            sp.setPlanNo(Integer.parseInt(params.get("sciencePlanID")));
            sp.setCreator(params.get("sciencePlanCreator"));
            sp.setFundingInUSD(Double.parseDouble(params.get("sciencePlanFunding")));
            sp.setObjectives(params.get("sciencePlanObjective"));
            // Sometimes date has problem so I format them.
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
            // DataProcRequirement object
            DataProcRequirement dpr = new DataProcRequirement(
                    params.get("dataProcessRequirementFileType"),
                    params.get("dataProcessRequirementFileQuality"),
                    params.get("dataProcessRequirementColorType"),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementContrast", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementExposure", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementBrightness", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementSaturation", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementLuminance", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementHue", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementHighlights", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementShadows", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementWhites", "0")),
                    Double.parseDouble(params.getOrDefault("dataProcessRequirementBlacks", "0"))
            );
            sp.setDataProcRequirements(dpr);
            // Submit to OCS
            OCS ocs = new OCS(true);
            ocs.createSciencePlan(sp);
            model.addAttribute("goode", "Start date cannot be after the end date.");
            return "create-science-plan-form";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create Science Plan: " + e.getMessage());
            return "create-science-plan-form";
        }
    }
}
