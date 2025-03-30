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

![](./designs/selected_diagram/UC03_acitivty_new.jpg)

## **Sequence Diagram**

![](./designs/selected_diagram/UC03_sequence_new.jpg)

## 
