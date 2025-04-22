#### Use case: create an observing program <br>
### **How to execute the observing program on Spring Boot app.**<br>
1. Clone this project <br>
2. Open the `build.gradle` file in intelli J application <br>
3. Click run and open browser go to this `http://localhost:63342/gemini-login/gemini-login.main/templates/observing-program.html?_ijt=3airtnjsgkudnlp2bqhpera264&_ij_reload=RELOAD_ON_SAVE` <br>

### **Explanation abouut our code** <br>
## For the fronted part <br>
HTML interface: `./implementations/gemini_login/src/main/resources/templates/observing-program.html` <br>

## For the backend part <br> 
1. In the controller folder, we create `observingProgramController.java`. <br>
2. We also use the library that provided from class, OCS library. We imported it at the top of the page, such as `import edu.gemini.app.ocs.model.ObservingProgram;` 
Since, we have used the OCS that provided from class. We also need to add the `OCS.jar` file. We create new folder, named `libs`. Since, I import `OCS.jar` file, so I add it in `build.gradle`. <br>
3. We also manage the `service` folder and create a service, `ObservingProgramService.java`. To call to use the observing program. <br>
4. We also put another file into `model` folder, `model/MyObservingProgram.java` <br>
