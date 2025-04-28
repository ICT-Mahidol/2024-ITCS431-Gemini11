package th.ac.mahidol.ict.gemini_login.model;

public class Configuration {

    private String details;  // e.g., description of the configuration
    private String filePath; // Path to the configuration file

    // Constructor
    public Configuration(String details, String filePath) {
        this.details = details;
        this.filePath = filePath;
    }

    // Getters and Setters
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Optionally, you can override toString, equals, or hashCode if needed
    @Override
    public String toString() {
        return "Configuration{" +
                "details='" + details + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
