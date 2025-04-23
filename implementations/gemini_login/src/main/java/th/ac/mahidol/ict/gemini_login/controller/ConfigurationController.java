package th.ac.mahidol.ict.gemini_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.ac.mahidol.ict.gemini_login.service.ConfigurationService;

@Controller
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    // Endpoint to view current configurations
    @GetMapping("/view-configurations")
    public String viewConfigurations(Model model) {
        String configurations = configurationService.getConfigurations();
        model.addAttribute("configurations", configurations);
        return "viewConfig";  // Returns the viewConfig.html template
    }

    // Endpoint to add new configuration (handle file upload)
    @PostMapping("/add-config")  // Make sure the method is POST
    public String addConfiguration(@RequestParam("configFile") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("statusMessage", "No file selected. Please choose a file.");
            return "uploadConfig";  // Return to the uploadConfig page with error message
        }

        // Handle the file upload and return the success/failure status
        boolean isSuccess = configurationService.addConfiguration(file);
        model.addAttribute("statusMessage", isSuccess ? "Configuration uploaded successfully." : "Failed to upload configuration.");
        return "uploadConfig";  // Return to the same page (uploadConfig.html)
    }
}
