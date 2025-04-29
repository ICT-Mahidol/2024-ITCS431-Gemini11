package th.ac.mahidol.ict.gemini_login.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.gemini.app.ocs.model.ObservingProgram;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyObservingProgram extends ObservingProgram {
    private String notes;
    private String telescopePositionPair;

    private int planNo;
    private String geminiLocation;
    private String opticsPrimary;
    private double fStop;
    private double opticsSecondaryRMS;
    private double scienceFoldMirrorDegree;
    private String scienceFoldMirrorTypeValue;   // <- renamed
    private String moduleContentValue;           // <- renamed
    private String calibrationUnitValue;         // <- renamed
    private String lightTypeValue;               // <- renamed

    private int id = 0;
    private String piName = "";
    private String telescopeName = "";
    private String site = "";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createDate = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate = new Date();

    private String dataPath = "";
    private String priority = "";
    private String status = "";

    // --- Getter and Setter for all fields ---
    public int getPlanNo() { return planNo; }
    public void setPlanNo(int planNo) { this.planNo = planNo; }

    public String getGeminiLocation() { return geminiLocation; }
    public void setGeminiLocation(String geminiLocation) { this.geminiLocation = geminiLocation; }

    public String getOpticsPrimary() { return opticsPrimary; }
    public void setOpticsPrimary(String opticsPrimary) { this.opticsPrimary = opticsPrimary; }

    public double getFStop() { return fStop; }
    public void setFStop(double fStop) { this.fStop = fStop; }

    public double getOpticsSecondaryRMS() { return opticsSecondaryRMS; }
    public void setOpticsSecondaryRMS(double opticsSecondaryRMS) { this.opticsSecondaryRMS = opticsSecondaryRMS; }

    public double getScienceFoldMirrorDegree() { return scienceFoldMirrorDegree; }
    public void setScienceFoldMirrorDegree(double scienceFoldMirrorDegree) { this.scienceFoldMirrorDegree = scienceFoldMirrorDegree; }

    public String getScienceFoldMirrorTypeValue() { return scienceFoldMirrorTypeValue; }
    public void setScienceFoldMirrorTypeValue(String scienceFoldMirrorTypeValue) { this.scienceFoldMirrorTypeValue = scienceFoldMirrorTypeValue; }

    public String getModuleContentValue() { return moduleContentValue; }
    public void setModuleContentValue(String moduleContentValue) { this.moduleContentValue = moduleContentValue; }

    public String getCalibrationUnitValue() { return calibrationUnitValue; }
    public void setCalibrationUnitValue(String calibrationUnitValue) { this.calibrationUnitValue = calibrationUnitValue; }

    public String getLightTypeValue() { return lightTypeValue; }
    public void setLightTypeValue(String lightTypeValue) { this.lightTypeValue = lightTypeValue; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getTelescopePositionPair() { return telescopePositionPair; }
    public void setTelescopePositionPair(String telescopePositionPair) { this.telescopePositionPair = telescopePositionPair; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPiName() { return piName; }
    public void setPiName(String piName) { this.piName = piName; }

    public String getTelescopeName() { return telescopeName; }
    public void setTelescopeName(String telescopeName) { this.telescopeName = telescopeName; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getDataPath() { return dataPath; }
    public void setDataPath(String dataPath) { this.dataPath = dataPath; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
