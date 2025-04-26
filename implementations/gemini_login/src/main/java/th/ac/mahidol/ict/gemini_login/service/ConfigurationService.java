package th.ac.mahidol.ict.gemini_login.service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.stream.Collectors;

@Service
public class ConfigurationService {

    // Method to load the current configuration
    public String loadCurrentConfiguration() throws IOException {
        String workingDir = System.getProperty("user.dir");
        File currentFile = new File(workingDir, "/references/gemini_config_current.json");

        if (!currentFile.exists()) {
            return "Current configuration not found!";
        }

        InputStream inputStream = new FileInputStream(currentFile);
        String jsonText = (new BufferedReader(new InputStreamReader(inputStream)))
                .lines().collect(Collectors.joining("\n"));

        return jsonText;  // Returning the JSON content as a string (or you can convert it to a JSONObject)
    }

    // Method to load the default configuration
    public String loadDefaultConfiguration() throws IOException {
        String workingDir = System.getProperty("user.dir");
        File defaultFile = new File(workingDir, "/references/gemini_config_default.json");

        if (!defaultFile.exists()) {
            return "Default configuration not found!";
        }

        InputStream inputStream = new FileInputStream(defaultFile);
        String jsonText = (new BufferedReader(new InputStreamReader(inputStream)))
                .lines().collect(Collectors.joining("\n"));

        return jsonText;  // Returning the JSON content as a string (or you can convert it to a JSONObject)
    }

    // Method to update the current configuration
    public String updateConfiguration(String newConfigJson) throws IOException {
        String workingDir = System.getProperty("user.dir");
        File currentFile = new File(workingDir, "/references/gemini_config_current.json");

        // Write the updated configuration to the current file
        try (FileWriter writer = new FileWriter(currentFile)) {
            writer.write(newConfigJson);
        }

        return "Configuration updated successfully!";
    }
}
