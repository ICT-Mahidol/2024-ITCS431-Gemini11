package th.ac.mahidol.ict.gemini_login.service;

import edu.gemini.app.ocs.example.MyObservingProgram;
import org.springframework.stereotype.Service;

@Service
public class ObservingProgramService {
    public MyObservingProgram createObservingProgram(MyObservingProgram program) {
        // OCS validation logic
        return (MyObservingProgram) program.validateObservingCondition(program);
    }
}
