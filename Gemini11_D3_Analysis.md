## 

## **Use case Description**

| Use Case Name: Install new subsystems and configuration | ID: 01 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: Support Staff |  | Use Case Type: User Initiated |
| Stakeholders and Interests: **Support Staff**: Responsible for installing new subsystems and ensuring that they integrate correctly with the existing infrastructure. They need a smooth, error-free process to maintain operational stability. **Telescope Operator**: Relies on properly configured subsystems to ensure accurate telescope control and observational operations. **Astronomer**: Needs the installed subsystems to function correctly to support scientific observations and data collection. **Science Observer**: Uses the telescope and its subsystems indirectly and depends on their correct configuration for seamless operation. **Administrators**: Oversee system integrity and may need to approve or review installations for compliance with observatory standards.   |  |  |
| Brief Description: The use case describes the process for installing new subsystems and configuring them for use in operations. The support staff will initiate the installation process after validating the configuration files. The system then makes updates, applies the configuration, and performs diagnostics. Errors are rolled back with a log issue for troubleshooting. When the successful installation process has been verified, the system updates its logs, and support staff confirm that the subsystem is ready.  |  |  |
| Trigger: The support staff initiates the installation process for new subsystems.   Type: User-Initiated |  |  |
| Relationships: 	Association: Support Staff 	Include: File Validation, Installation Execution 	Extend: Error handling, Rollback Process |  |  |
| Normal Flow of Events: The support staff logs into the system. The support staff navigates to the "Subsystem Installation" section. The system displays available installation options. The support staff selects a subsystem and uploads configuration files. The system validates the uploaded files. If files are invalid, an error message is displayed, and staff re-uploads files. If valid, the system proceeds with the installation. The system updates and reconfigures the necessary components. The system confirms successful installation and updates the logs. The support staff verifies system status and logs out.   |  |  |
| Subflows: **1a:** Support staff checks system logs for prior installation history. **2a:** Support staff saves a report of the installation process for future reference.  |  |  |
| Alternate/Exceptional Flow: **AE1:** If the system fails to authenticate the user, access is denied. **AE2:** If an invalid configuration file is uploaded, the system prompts for re-upload. **AE3:** If the installation fails, the system rolls back changes and logs an error.     |  |  |

## 

## **Activity Diagram**

![][diagram/UC01_activity.png]

## **Sequence Diagram**

![][diagram/UC1_sequence.png]



Science Observer: Create an Observing Program

## **Use case Description**

| Use Case Name: Create an observing plan | ID: 02 | Important Level: High |
| :---- | :---- | :---- |
| Primary Actor: Science Observer | Use Case Type: Essential |  |
| Stakeholders and Interests: **Astronomer**: Proposes and defines the science plan. **Science Observer**: Validates and transforms the science plan into an executable observing program. **Telescope: Operator:** Ensures that the telescope is properly configured and operational. **Observatory Operations Staff**: Manages overall scheduling and telescope availability. **System Administrators / IT Support**: Maintains the Observatory Control System (OCS) software and hardware. **Observatory Management & Scheduling Committee**: Oversees the allocation of telescope time and ensures alignment with observatory goals. |  |  |
| Brief Description: The use case demonstrates the process of creating an observing program by defining observation sequences, configuring telescope and instrument settings, integrating with the scheduling system, preparing for automated execution and validation. |  |  |
| Trigger: The science observer initiated the process of creating an observing plan. Type: User Initiated |  |  |
| Relationships:    Association:  Science Observer    Include: Validate Observation Sequences \-\> verify observation feasibility, validate telescope and instrument Parameters \-\> check Telescope & instrument readiness, final Review & validation \-\> perform final observing program validation    Extent: validate observation sequences \<-\> revise observation Sequences, validate telescope and instrument parameters \<-\> adjust telescope & instrument settings, integrate with scheduling system \<-\> reschedule observation program,  final review & validation \<-\> request additional review    Generalization: manage observing plans \-\> create an observing program, validate observing parameters \-\> validate observation sequences, validate observing parameters \-\> validate telescope and instrument parameters |  |  |
| Normal Flow of Events: The science observer receive the validated science plan The science observer define observation sequences The science observer validate observation sequences The science observer set up telescope and instrument parameters The science observer validate telescope and instrument parameters The science observer integrate with scheduling system The science observer prepare for automated execution The science observer does the final review and validation The science observer submit the observing program  |  |  |
| SubFlows: 1a: Verify completeness and correctness. 2a: Assign telescope pointing, exposure times, and calibration steps. 3a: Check feasibility against telescope and environmental constraints. 4a: Configure tracking, guiding, filters, and detector settings. 5a: Ensure all configurations meet requirements. 6a: Assign priority and allocate observation slots. 7a: Format for observatory control system, run simulations if needed. 8a: Confirm program readiness and compliance. 9a: Send to the system for execution. |  |  |
|  Alternate/Exception Flows: 1b: If the validated science plan has issues, determine whether they are minor or major. 1c: If the issues are minor Request changes from the astronomer. The astronomer resubmits the plan, and the process restarts. 1d: If the issues are major, reject the plan. 3b: If issues are found in the observation sequences, check if they can be fixed. 3c: If feasible, modify the observation sequences and revalidate them. 3d: If not feasible, the process stops. 5b: If the selected instrument is unavailable, an alternate instrument is selected. 5c: If the telescope is malfunctioning, determine if it can be rescheduled. 5d: If rescheduling is possible, wait for the telescope to function and retry. 5e: If rescheduling is not possible, the process stops. 6b: If there is a scheduling conflict during integration with the scheduling system, adjust and reschedule. 7b: If errors occur while preparing for automated execution, optimize settings and fix errors. 8b: If issues are found in the final review, fix them before submitting.  |  |  |

## **Activity Diagram**

![][diagram/UC02_activity.png]

## **Sequence Diagram**

![][diagram/UC02_sequence.png]



Telescope operator: Control the telescope via command line.

## **Use case Description**

| Use Case Name: Control the Telescope via Command Line | ID: 03 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: Telescope Operator |  | Use Case Type: User Initiated |
| Stakeholders and Interests: **Telescope Operator:** Needs to control the telescope for observational and operational purposes using the command line interface. **Astronomer:** Requires telescope control for executing a science plan and gathering data. **Science Observer:** May rely on command-line control for indirect telescope operations. |  |  |
| Brief Description: This use case describes how a telescope operator controls the telescope using the command line to modify the location of the telescope, set up observational parameters, and check that everything is correctly implemented for making the astronomical observations.     |  |  |
| Trigger: The telescope operator initiates a command-line session to control the telescope.   Type: User-Initiated |  |  |
| Relationships: 	Association: Telescope Operator 	Include: 	Extend: 	Generalization: |  |  |
| Normal Flow of Events: 1\. The telescope operator logs into the system. 2\. The operator opens the command-line interface for telescope control. 3\. The system authenticates the user and provides access to control commands. 4\. The operator inputs commands to adjust the telescope's position and configure settings. 5\. The system executes the commands and provides real-time feedback. 6\. The telescope responds accordingly, adjusting to the specified parameters. 7\. The operator verifies the telescope’s response and makes any necessary adjustments. 8\. The operator completes the session and logs out of the system.   |  |  |
| Sub flows: 4a: Operator requests the status of the telescope before making adjustments. 7a: Operator saves the command logs for future reference. |  |  |
| Alternate/Exceptional Flow: 1b: If the system fails to authenticate the user, access is denied. 2b: If an invalid command is entered, the system provides an error message and suggests correct syntax. 4b: If the telescope fails to respond, the operator is notified of a possible hardware or software issue.     |  |  |

## **Activity Diagram**

![][diagram/UC03_activity.png]

## **Sequence Diagram**

![][diagram/UC3_sequence.png]



## **Use case Description**

| Use Case Name: Control High-level Functions | ID: 04 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor:  Administrator  |  | Use Case Type: Essential |
| Stakeholders and Interests: **Administrator:** responsible to control and manage high-level functions and systems **Every users:** need the roll granted by the high-level functions to operate the systems |  |  |
| Brief Description: This case allows Administrators to control high-level functions, including defining user access modes, managing users, and defining operation levels.     |  |  |
| Trigger:   Type: User-Initiated |  |  |
| Relationships: 	Association: Administrator, Every users 	Include: 	Extend:Define user’s access mode, User Management, Define operation level  	Generalization: |  |  |
| Normal Flow of Events: Administrator logs into the system. Administrator opens up the high-level feature control panel. Administrator selects the feature to operate/ control. Administrator saves the configurations. |  |  |
|  Sub flows: 3a: Define User Access Modes: 1a: Administrator selects "User Access Modes" from the control panel. 2a: The system displays a list of current user access modes. 3a: Administrator modifies the access modes as needed. 4a: Administrator confirms the changes. 3b: Manage Users: 1b: Administrator selects "Manage Users" from the control panel. 2b: The system displays a list of current users. 3b: Administrator adds, removes, or updates user information. 4b: Administrator confirms the changes. 3c: Define Operational Levels: 1c: Administrator selects "Operational Levels" from the control panel. 2c: The system displays the current operational levels. 3c: Administrator modifies the operational levels as needed 4c: Administrator confirms the changes.  |  |  |
| Alternate/Exceptional Flow: AE1: If the system fails to authenticate the user, access is denied. AE2: If non-administrator attempt to access these features, the system will deny the access. AE3: If an administrator provides invalid form of inputs while managing high-level features, the system will display error access and deny the input. AE4: if the system failed to save the configuration the system rolls back the changes and shows the error logs. |  |  |

## **Activity Diagram**

![][diagram/UC04_activity.png]

## **Sequence Diagram**

![][diagram/UC4_sequence.png]



## **Use case Description**

| Use Case Name: Create a science plan |  | ID: 05 |  | Importance Level: High |  |
| :---- | ----- | :---- | :---- | :---- | ----- |
| Primary Actor: Astronomer |  |  | Use Case Type: Essential |  |  |
| Stakeholders and Interests:  **Primary Actor:** Astronomer wants to create, test, and submit a science plan efficiently. **Secondary Actors:** Science Observe ensures the science plan is valid and executable. Telescope Operator ensures the telescope and instruments are used correctly. Administrator oversees scheduling and system operations. Support & Developer Team maintaining system functionality and fixing issues. |  |  |  |  |  |
| Brief Description: This use case describes how to create a science plan. |  |  |  |  |  |
| Trigger:  A science plan submission might trigger a validation process. A weather change could trigger a rescheduling of the observation. A telescope error might trigger a diagnostic sequence. Type: Internal |  |  |  |  |  |
| Relationships: Association: astronomer, science observer, operation staff Include: create science plan \-\> simulate science plan, validate science plan \-\> check instrument configuration Extend: create science plan \<-\> modify science plan, validate observing program \<-\> adjust program for scheduling conflicts. Generalization: execute observing program \-\> execute program with adjustments |  |  |  |  |  |
| Normal Flow Events: The astronomer creates a science plan. The astronomer submits the science plan. Science Observer validates the science plan. Operation staff transform the science plan into an observing program. Operation staff validate the observing program. Science observer executes the observing program. The astronomer collects and validates data. |  |  |  |  |  |
| Subflows: 1a. Use the virtual telescope to test feasibility. 2a. System checks for completeness. 3a: Observer checks instrument and schedule feasibility. 4a: Ensure compatibility with the observing queue. 5a: Validate telescope operation and safety. 6a: Monitor progress and adjust as needed. 7a: Ensure image quality and completeness. |  |  |  |  |  |
| Alternate/Exceptional Flow:  1b: Modify the plan if the simulation fails. 2b: Plan is rejected if details are missing. 3b: If conflicts exist, request plan revision. 4b: Adjust the program if scheduling conflicts arise. 5b: Reject the program if it risks system stability. 6b: Reschedule if interrupted by technical issues. 7b: If data is corrupt, schedule re-observation. |  |  |  |  |  |

## **Activity Diagram**

![][diagram/UC05_activity.png]

## **Sequence Diagram**

![][diagram/UC5_sequence.png]


##

##

## **Class Diagram**

![][diagram/ClassDiagram.png]
