# Gemini11 Login

A Spring Boot-based web application that provides login functionality and secure access to Gemini11 science planning features.

## 📌 Overview

This project is part of the Gemini11 system developed by students at Mahidol University. It is focused on user authentication and session management for accessing astronomy science plans, likely integrating with external telescope control systems. 

However, the implementation in this directory only implement limited amount of use cases, which are:
- Create Science plan (done by Astronomer role)
- Install New Configurations and Subsystems (done by Support Staff role)
- Create an observing program (done by Science Observer role)
The use case description, activity diagram, and sequence diagram corresponding to these use cases are located in Gemini11_D5_Analysis.md, which located in designs folder

Additionally, the login system has been implemented and the only way to create new account can only be done by logging in as Admin.

Technologies used:
- Spring Boot 3.0
- Java 19
- Spring Security
- Thymeleaf
- Gradle
- H2 Database (via `.mv.db` file)

## 🚀 Getting Started

### Prerequisites
- Java 19 or higher
- Gradle 8
- Internet access to fetch dependencies
- Have OCS.jar located somewhere in the directory (already located in the project)
- Preferably IDE that can run Gradle, recommended Intellij IDEA community edition

### Run the Application

due to various circumstance, the preferable run enviroment is to open the project inside Intellij.
First, navigate to implementations/gemini_login, then select the following folder as a project folder to open.
Then, after setup the JDK to version 19 or higher, manual click at build.gradle to build.
After build, navigate throught src/main/java/th.ac.mahidol.ict.gemini_login/ to run GeminiLoginApplication.java

After the application run succesfully and springboot server is online, go to localhost/8080/login through local browser, then the user will be greeted with the login page. These are account registered as each role required to test the system:

| Username     | Role                  |
|-------------|-----------------------|
| Admin       | ROLE_ADMINISTRATOR    |
| arustronomer | ROLE_ASTRONOMER       |
| aruSupport   | ROLE_SUPPORT_STAFF    |
| aruScience   | ROLE_SCIENCE_OBSERVER |

noted that admin have the password as 'Admin' and the rest have the password as '12345'


## how-to guide to nevigate through each usecases

---

### Create a New Science Plan

1. Login as Astronomer 'arustronomer'

2. You will be redirected to view science plan page
 
3. Click create new science plan to go to science plan page
 
4. Fill all of the required parameters.
 
5. Click save science plan
 
 
#### Frontend:
 
path ./src/main/resources/templates
 
   create-science-plan-form.html
      - This page is for creating a science plan form.
      - The science plan data will be saved as a JSON in the path ./references/science_plan
 
   view-science-plan.html     
      - This page is for viewing all of the science plan.
      - The science plan will be parsed from JSON in the path ./references/science_plan
 
#### Backend:
 
   Controller
      - sciencePlanController
         - This handles the GET and POST mapping in the app. 
         - This handles the data and saves the science plan as a JSON file.

---

### Install new configuration
1. Login as Support staff 'aruSupport'
2.  You can view current config and default configuration in this page
3.  Press 'Choose file' to upload json and 'update configuration' to update the current config
4.  Press 'Download Current Configuration'

### Frontend:
path ./src/main/resources/templates
   configurationPage.html
   - The page will show current configuration and default configuration
   - The currentConfig will be stored  in reference folder as .JSON file
   - The curerntConfiguration can be replace by upload new confgiration file

### Backend
ConfigurationController
   - This handle view, view-default, update and download the configuration
   - It will save the configuration file in reference folder.

ConfigurationService
   - This will call variety method in OCS.jar like loadCurrent, loadDefault and updateConfiguration
       
---

### Create an Observing Program

1. Login as Science Observer 'aruScience'

2. You will be redirected to create observer program page, which you must fill every field with valid data before creating
 
3. You can view the existed observing program by clicking 'View List' button at the top left corner of the page
 
4. In the view page, you will be presented with every observing plan sorted by plan number. Users can Edit or delete observing plans here via action button on the right-most column of each rows.
 
#### Frontend:
 
path ./src/main/resources/templates
 
   observing-program.html, observing-program-form-edit.html, observing-program-list.html
      - the observing plan will be stored in reference folder as .JSON file
      - the plan number will be auto-increment and added as a key attribute
 
#### Backend:
 
   Controller
      - ObservingProgramController
         - This handles the GET and POST mapping in the app. 
         - This handles the data and saves the observing program as a JSON file.

---

# Design Pattern

The implementation of **@Service, @Configuration, @Repository** used in corresponding part of the program are **Singleton**, because the spring controller will marked it as singleton and create only one instance of each one. 
<br>

The **Facade** pattern also used in **ConfigurationService, ObservingProgramService, and UserService** listed in the service folder in order to called controller and model to work together for the greater good and the sake of error control that it will be appeared only at the service in case other modules has been ensured as a clean, non error code.
<br>

Stpring Security also contain **Strategy** Pattern as it contains strategies to control login at runtime instead of embed the logic directly within a class to handle different stages of event in login process and other configuration installment processes.



