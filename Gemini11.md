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


# Design Pattern

The implementation of **@Service, @Configuration, @Repository** used in corresponding part of the program are **Singleton**, because the spring controller will marked it as singleton and create only one instance of each one. 
<br>

The **Facade** pattern also used in **ConfigurationService, ObservingProgramService, and UserService** listed in the service folder in order to called controller and model to work together for the greater good and the sake of error control that it will be appeared only at the service in case other modules has been ensured as a clean, non error code.
<br>

Stpring Security also contain **Strategy** Pattern as it contains strategies to control login at runtime instead of embed the logic directly within a class to handle different stages of event in login process and other configuration installment processes.



