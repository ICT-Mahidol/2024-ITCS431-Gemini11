package th.ac.mahidol.ict.gemini_login.repository;

import org.springframework.stereotype.Repository;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import th.ac.mahidol.ict.gemini_login.model.Configuration;  // Import Configuration

@Repository
public class ConfigurationRepository {

    private final String configFilePath = "/path/to/config/file"; // Path to your configuration file

    // Get the current configuration details
    public Configuration getCurrentConfiguration() {
        // Retrieve and return the current configuration
        return new Configuration("Current configuration details", "config-file-path");
    }

    // Get the current configuration as file data
    public byte[] getCurrentConfigurationFileData() {
        try {
            return Files.readAllBytes(Paths.get(configFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the current configuration file.", e);
        }
    }

    // Create a backup of the current configuration
    public void createBackup() {
        // Code to backup the current configuration (e.g., copy the file)
    }

    // Apply the new configuration file
    public boolean applyNewConfiguration(MultipartFile file) {
        try {
            // Save the new configuration to the proper location
            Files.write(Paths.get(configFilePath), file.getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Rollback to the previous configuration if installation fails
    public void rollbackToPreviousConfiguration() {
        // Code to revert to the backup configuration
    }
}
