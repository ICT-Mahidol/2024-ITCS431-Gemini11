//package th.ac.mahidol.ict.gemini_login.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import edu.gemini.app.ocs.OCS;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class ConfigurationService {
//
//    private OCS ocs;  // This will be used to call methods from OCS
//
//    // Path to save the uploaded configuration file
//    private final String configFilePath = "/data/data/config/file";  // Change this path to your desired location
//
//    // Constructor to initialize OCS instance
//    public ConfigurationService() {
//        this.ocs = new OCS();  // Create an instance of OCS to interact with the database
//    }
//
//    // Method to retrieve configurations from the database
//    public String getConfigurations() {
//
//        try {
//             ocs.getDefaultConfiguration();  // Calls the OCS method to get the configurations
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "";
//    }
//
//    // Method to add a new configuration (handling file upload)
//    public boolean addConfiguration(MultipartFile file) {
//        if (file.isEmpty()) {
//            return false;  // Return false if the file is empty
//        }
//
//        // Save the file to the specified directory and return the file path
//        String filePath = saveConfigurationFile(file);
//
//        // If file is successfully saved, add the configuration to the database
//        return filePath != null && ocs.addConfiguration(filePath);
//        ocs.
//    }
//
//    // Method to remove an existing configuration
//    public boolean removeConfiguration(int confNo) {
//        return ocs.removeConfiguration(confNo);  // Calls the OCS method to remove the configuration from the database
//    }
//
//    // Helper method to save the uploaded file to a directory and return the file path
//    private String saveConfigurationFile(MultipartFile file) {
//        try {
//            // Define the path to save the file
//            Path path = Paths.get(configFilePath + "/" + file.getOriginalFilename());
//            File fileToSave = new File(path.toString());
//
//            // Save the file to the disk
//            file.transferTo(fileToSave);
//
//            return fileToSave.getPath();  // Return the path where the file was saved
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;  // Return null if there's an error saving the file
//        }
//    }
//}
