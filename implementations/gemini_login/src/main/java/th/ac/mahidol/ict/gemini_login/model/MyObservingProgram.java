package th.ac.mahidol.ict.gemini_login.model;
import th.ac.mahidol.ict.gemini_login.model.MyObservingProgram;
import th.ac.mahidol.ict.gemini_login.model.MyObservingProgram;

import edu.gemini.app.ocs.model.ObservingProgram;

public class MyObservingProgram extends ObservingProgram {
    private String notes;
    private String telescopePositionPair;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTelescopePositionPair() {
        return telescopePositionPair;
    }

    public void setTelescopePositionPair(String telescopePositionPair) {
        this.telescopePositionPair = telescopePositionPair;
    }

}
