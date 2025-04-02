<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 23%" />
<col style="width: 41%" />
</colgroup>
<tbody>
<tr>
<td>Use Case Name: Create a science plan</td>
<td>ID: 01</td>
<td>Importance Level: High</td>
</tr>
<tr>
<td colspan="2">Primary Actor: Astronomer</td>
<td>Use Case Type: Essential</td>
</tr>
<tr>
<td colspan="3"><p><strong>Stakeholders and Interests:</strong></p>
<p><strong>Primary Actor:</strong> Astronomers want to create a science plan</p>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Brief Description:</strong></p>
<p>This use case describes how to create a science plan.</p>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Trigger:</strong> The science observer initiated the process of creating an observing plan.</p>
<p><strong>Type:</strong> User-Initiated</p>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Relationships:</strong></p>
<p><strong>Association:</strong> Astronomers</p>
<p>Include: -</p>
<p>Extent: -</p>
<p>Generalization: -</p>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Normal Flow Events:</strong></p>
<ol>
<li>The astronomer selects the “Create Science Plan” menu item.</li>
<li>The system displays the Create a Science Plan page.</li>
<li>The astronomer selects a button to create a new science plan.</li>
<li>The System shows the create science plan form</li>
<li>The astronomer fills in all the details. </li>
<li>The astronomer selects the Data processing requirements. </li>
<li>The astronomer creates the science plan by clicking the “Save Science Plan” button.</li>
</ol>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Subflows:</strong></p>
<ul>
<li>5a. Plan ID – automatically generated</li>
<li>5b. Plan Name – short plain text</li>
<li>5c. Creator – automatically filled using the astronomer's account information</li>
<li>5d. Funding – numerical values in Dollars with decimal points</li>
<li>5e. Objective – long plain text</li>
<li>5f. Start and End dates – select from a calendar</li>
<li>5g. Telescope assigned – a list of two telescopes: Hawaii and Chile</li>
<li>5h. Target – based on the star system selected from a list of star catalogue</li><br>
<li>6a. FileType – PNG, JPEG, RAW</li>
<li>6b. FileQuality – Low, Fine</li>
<li>6c. ColorType – Color mode, B&W mode</li>
<li>6d. Contrast – decimal values (for both color and B&W modes)</li>
<li>6e. Brightness – decimal values (only for color mode)</li>
<li>6f. Saturation – decimal values (only for color mode)</li>
<li>6g. Highlights – decimal values (only for B&W mode)</li>
<li>6h. Exposure – decimal values (for both color and B&W modes)</li>
<li>6i. Shadows – decimal values (only for B&W mode)</li>
<li>6j. Whites – decimal values (only for B&W mode)</li>
<li>6k. Blacks – decimal values (only for B&W mode)</li>
<li>6l. Luminance – decimal values (only for color mode)</li>
<li>6m. Hue – decimal values (only for color mode)</li>
</ul>
</td>
</tr>
<tr>
<td colspan="3"><p><strong>Alternate/Exceptional Flow:</strong></p>
<ul>
<li>6a. If any required field is missing or incorrect, the system displays an error message and the astronomer select the data processing requirement again.</li>
<li>6b: If the selected Schedule has a start date after an end date, the system alerts 
with a “Start date cannot be after the end date”. </li>
<li>If the input data is not compatible with the legacy OCS system (e.g., invalid file format, unsupported field values, or missing required information), the system displays an error message: “Input data is not compatible with the legacy OCS system.</li>
</ul>
</td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./selected_diagram/UC01_activity_new.png)

## **Sequence Diagram**

![](./selected_diagram/UC01_sequence_new.png)

## 
<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 23%" />
<col style="width: 41%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Install New Configurations and Subsystems</td>
<td>ID: 02</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Support Staff</td>
<td>Use Case Type: User Initiated</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<p><strong>Support Staff</strong>: Requires straightforward installation process with clear status updates.</p>
<p><strong>Telescope Operator</strong>: Needs assurance that configuration changes won't disrupt ongoing operations.</p>
<p><strong>System Administrators</strong>: Need complete records of all configuration changes.</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Brief Description:</p>
<p>This use case covers the installation of new subsystem configurations through a streamlined process. Support staff can upload and apply new configurations while maintaining the ability to revert changes if needed.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger: Support staff initiates new configuration installation process.</p>
<p>Type: User-Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Support Staff</p>
<p>Include: Configuration Validation</p>
<p>Extend: Rollback Process</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<ol type="1">
<li><p>Support staff navigates to "Subsystem Configuration" section.</p></li>
<li><p>System displays current configuration with options to download or install new configuration.</p></li>
<li><p>Support staff selects "Install New Configuration" option.</p></li>
<li><p>System presents upload interface for new configuration files.</p></li>
<li><p>System performs basic validation checks:
<ul>
<li>File structure integrity</li>
<li>Required fields presence</li>
</ul></p></li>
<li><p>System applies new configuration.</p></li>
<li><p>System displays installation completion status.</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="3"><p>Subflows:</p>
<ul>
<li><p><strong>SF1:</strong> System creates backup of previous configuration.</p></li>
<li><p><strong>SF2:</strong> Support staff can download current configuration before changes.</p></li>
</ul></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exceptional Flow:</p>
<ul>
<li><p><strong>AE1:</strong> Invalid configuration file - System rejects upload and specifies errors.</p></li>
<li><p><strong>AE2:</strong> Installation failure - System automatically reverts to previous configuration and notify the user.</p></li>
</ul></td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./selected_diagram/UC02_activity_new.png)

## **Sequence Diagram**


![](./selected_diagram/UC02_sequence_new.png)

## 

<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 23%" />
<col style="width: 41%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Create an observing program</td>
<td>ID: 03</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Science Observer</td>
<td>Use Case Type: Essential</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<p><strong>Science Observer</strong>: wants to create an observing program by transforming a validated science plan.
</p>
</td>
</tr>
<tr class="even">
<td colspan="3"><p>Brief Description:</p>
<p>This use case describes the process by which a science observer converts a validated science plan into an observing program. The observing program includes essential parameters such as Gemini location, optics configuration, calibration details, and telescope positioning data to ensure accurate execution.
</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger: After validating a science plan, the science observer initiates the transformation of the science plan into an observing program.
</p>
<p>Type: User-Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Science Observer</p>
<p>Include: -</p>
<p>Extend: -</p>
<p>Generalization: -</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<ol type="1">
<li><p>The science observer navigates to the "Create an Observing Program" page. 
</p></li>
<li><p>The system presents a list of validated science plans.
</p></li>
<li><p>The science observer selects a validated science plan to create an observing program.
</p></li>
<li><p>The system loads the selected science plan, allowing the science observer to define the observing program.</p></li>
<li><p>The science observer enters required details for the observing program.
</p>
<li><p>The science observer finalizes the observing program by clicking the "Create Observing Program" button.
</p>
<li><p>The system updates the validation status of the observing program.
</p>
<li><p>The system confirms the creation of the observing program and updates the system records.
</p>
<ul>
</ol></td>
</tr>
<tr class="even">
<td colspan="3"><p>Subflows:</p>
<ul>
<li><p>5a: Gemini Location – Specifies the location where the observation will take place.
</p></li>
<li><p>5b: Optics Primary – Defines the primary optics settings.</p></li>
<li><p>5c:  F-stop – Determines the aperture settings for the telescope.
</p></li>
<li><p>5d: Optics Secondary RMS – Sets the secondary optics root mean square (RMS) values. 
</p></li>
<li><p>5e: Science Fold Mirror Degree – Configures the angle of the fold mirror. 
</p></li>
<li><p>5f: Science Fold Mirror Type – Selects the appropriate type of fold mirror. 
</p></li>
<li><p>5g: Module Content – Specifies the module data required for observation.  
</p></li>
<li><p>5h:  Calibration Unit – Defines the calibration settings for accuracy. 
</p></li>
<li><p>5i: Light Type – Determines the type of light source used during observation.  
</p></li>
<li><p>5j: Telescope Position Pair – Sets the positional coordinates for telescope alignment. 
</p></li>
</ul></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exceptional Flow:</p>
<ul>
<li><p>AE1: If there are no validated science plans available, the system displays "No validated science plans found." </p></li>
<li><p>AE2: If required details are missing or invalid, the system prompts the science observer to enter the necessary information before proceeding.
</p></li>
<li><p>AE3: If the system encounters an error during the creation process, it displays an appropriate error message and logs the issue.
</p></li>
</ul></td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./selected_diagram/UC03_activity_new.jpg)

## **Sequence Diagram**

![](./selected_diagram/UC03_sequence_new.jpg)

## 
## **Class Diagram**

![](./selected_diagram/class_diagram_new.png)
