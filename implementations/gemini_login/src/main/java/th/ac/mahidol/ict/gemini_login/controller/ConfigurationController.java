package th.ac.mahidol.ict.gemini_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.ac.mahidol.ict.gemini_login.service.ConfigurationService;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;


    // Endpoint to view current configurations
    @GetMapping("/view-configurations")
    public String viewConfigurations(Model model) {
        try {
            // Load current configuration and display it
            String currentConfig = configurationService.loadCurrentConfiguration();
            model.addAttribute("configurations", currentConfig);
        } catch (IOException e) {
            model.addAttribute("statusMessage", "Error loading current configuration: " + e.getMessage());
            e.printStackTrace();
        }
        return "configurationPage";  // Return the configurationPage.html template
    }

    // Endpoint to view default configurations
    @GetMapping("/view-default-config")
    public String viewDefaultConfig(Model model) {
        try {
            // Load default configuration and display it
            String defaultConfig = configurationService.loadDefaultConfiguration();
            model.addAttribute("configurations", defaultConfig);
        } catch (IOException e) {
            model.addAttribute("statusMessage", "Error loading default configuration: " + e.getMessage());
            e.printStackTrace();
        }
        return "configurationPage";  // Return the configurationPage.html template
    }

    // Endpoint to upload and update the current configuration
    @PostMapping("/update-config")
    public String updateConfiguration(@RequestParam("newConfig") MultipartFile newConfigFile, Model model) {
        try {
            // Convert the uploaded file to a string (JSON)
            String newConfigJson = new String(newConfigFile.getBytes());

            String updateStatus = configurationService.updateConfiguration(newConfigJson);  // Update configuration
            model.addAttribute("statusMessage", updateStatus);
        } catch (IOException e) {
            model.addAttribute("statusMessage", "Error updating configuration: " + e.getMessage());
            e.printStackTrace();
        }
        return "configurationPage";  // Return to the configuration page with status message
    }

    @GetMapping("/download-config")
    public @ResponseBody byte[] downloadConfig() throws IOException {
        String workingDir = System.getProperty("user.dir");
        File currentFile = new File(workingDir, "/references/config/gemini_config_current.json");

        if (!currentFile.exists()) {
            throw new IOException("Current configuration file not found!");
        }

        // Read the file content
        Path path = Paths.get(currentFile.getAbsolutePath());
        return Files.readAllBytes(path);  // Return the content as byte array for download
    }

    // Validate JSON format
//    private boolean isJSONValid(String test) {
//        try {
//            new org.json.JSONObject(test); // Try to create a JSONObject, if it fails, it's not valid
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
}
