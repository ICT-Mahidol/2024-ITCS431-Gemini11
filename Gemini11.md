# Gemini11 Login

A Spring Boot-based web application that provides login functionality and secure access to Gemini11 science planning features.

## 📌 Overview

This project is part of the Gemini11 system developed by students at Mahidol University. It is focused on user authentication and session management for accessing astronomy science plans, likely integrating with external telescope control systems.

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




