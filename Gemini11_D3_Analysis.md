<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 23%" />
<col style="width: 41%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Install new subsystems and configuration</td>
<td>ID: 01</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Support Staff</td>
<td>Use Case Type: User Initiated</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<p><strong>Support Staff</strong>: Responsible for installing new
subsystems and ensuring that they integrate correctly with the existing
infrastructure. They need a smooth, error-free process to maintain
operational stability.</p>
<p><strong>Telescope Operator</strong>: Relies on properly configured
subsystems to ensure accurate telescope control and observational
operations.</p>
<p><strong>Astronomer</strong>: Needs the installed subsystems to
function correctly to support scientific observations and data
collection.</p>
<p><strong>Science Observer</strong>: Uses the telescope and its
subsystems indirectly and depends on their correct configuration for
seamless operation.</p>
<p><strong>Administrators</strong>: Oversee system integrity and may
need to approve or review installations for compliance with observatory
standards.</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Brief Description:</p>
<p>The use case describes the process for installing new subsystems and
configuring them for use in operations. The support staff will initiate
the installation process after validating the configuration files. The
system then makes updates, applies the configuration, and performs
diagnostics. Errors are rolled back with a log issue for
troubleshooting. When the successful installation process has been
verified, the system updates its logs, and support staff confirm that
the subsystem is ready.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger: The support staff initiates the installation
process for new subsystems.</p>
<p>Type: User-Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Support Staff</p>
<p>Include: File Validation, Installation Execution</p>
<p>Extend: Error handling, Rollback Process</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<ol type="1">
<li><p>The support staff logs into the system.</p></li>
<li><p>The support staff navigates to the "Subsystem Installation"
section.</p></li>
<li><p>The system displays available installation options.</p></li>
<li><p>The support staff selects a subsystem and uploads configuration
files.</p></li>
<li><p>The system validates the uploaded files.</p>
<ul>
<li><p>If files are invalid, an error message is displayed, and staff
re-uploads files.</p></li>
</ul></li>
<li><p>If valid, the system proceeds with the installation.</p></li>
<li><p>The system updates and reconfigures the necessary
components.</p></li>
<li><p>The system confirms successful installation and updates the
logs.</p></li>
<li><p>The support staff verifies system status and logs out.</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="3"><p>Subflows:</p>
<ul>
<li><p><strong>1a:</strong> Support staff checks system logs for prior
installation history.</p></li>
<li><p><strong>2a:</strong> Support staff saves a report of the
installation process for future reference.</p></li>
</ul></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exceptional Flow:</p>
<ul>
<li><p><strong>AE1:</strong> If the system fails to authenticate the
user, access is denied.</p></li>
<li><p><strong>AE2:</strong> If an invalid configuration file is
uploaded, the system prompts for re-upload.</p></li>
<li><p><strong>AE3:</strong> If the installation fails, the system rolls
back changes and logs an error.</p></li>
</ul></td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./diagram/UC01_activity.png)

## **Sequence Diagram**

![](./diagram/UC01_sequence.png)

## 

<table>
<colgroup>
<col style="width: 45%" />
<col style="width: 20%" />
<col style="width: 33%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Create an observing plan</td>
<td>ID: 02</td>
<td>Important Level: High</td>
</tr>
<tr class="even">
<td>Primary Actor: Science Observer</td>
<td colspan="2">Use Case Type: Essential</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<ol type="1">
<li><p><strong>Astronomer</strong>: Proposes and defines the science
plan.</p></li>
<li><p><strong>Science Observer</strong>: Validates and transforms the
science plan into an executable observing program.</p></li>
<li><p><strong>Telescope: Operator:</strong> Ensures that the telescope
is properly configured and operational.</p></li>
<li><p><strong>Observatory Operations Staff</strong>: Manages overall
scheduling and telescope availability.</p></li>
<li><p><strong>System Administrators / IT Support</strong>: Maintains
the Observatory Control System (OCS) software and hardware.</p></li>
<li><p><strong>Observatory Management &amp; Scheduling
Committee</strong>: Oversees the allocation of telescope time and
ensures alignment with observatory goals.</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="3">Brief Description: The use case demonstrates the process
of creating an observing program by defining observation sequences,
configuring telescope and instrument settings, integrating with the
scheduling system, preparing for automated execution and
validation.</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger: The science observer initiated the process
of creating an observing plan.</p>
<p>Type: User Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Science Observer</p>
<p>Include: Validate Observation Sequences -&gt; verify observation
feasibility, validate telescope and instrument Parameters -&gt; check
Telescope &amp; instrument readiness, final Review &amp; validation
-&gt; perform final observing program validation</p>
<p>Extent: validate observation sequences &lt;-&gt; revise observation
Sequences, validate telescope and instrument parameters &lt;-&gt; adjust
telescope &amp; instrument settings, integrate with scheduling system
&lt;-&gt; reschedule observation program, final review &amp; validation
&lt;-&gt; request additional review</p>
<p>Generalization: manage observing plans -&gt; create an observing
program, validate observing parameters -&gt; validate observation
sequences, validate observing parameters -&gt; validate telescope and
instrument parameters</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<ol type="1">
<li><p>The science observer receive the validated science plan</p></li>
<li><p>The science observer define observation sequences</p></li>
<li><p>The science observer validate observation sequences</p></li>
<li><p>The science observer set up telescope and instrument
parameters</p></li>
<li><p>The science observer validate telescope and instrument
parameters</p></li>
<li><p>The science observer integrate with scheduling system</p></li>
<li><p>The science observer prepare for automated execution</p></li>
<li><p>The science observer does the final review and
validation</p></li>
<li><p>The science observer submit the observing program</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="3"><p>SubFlows:</p>
<p>1a: Verify completeness and correctness.</p>
<p>2a: Assign telescope pointing, exposure times, and calibration
steps.</p>
<p>3a: Check feasibility against telescope and environmental
constraints.</p>
<p>4a: Configure tracking, guiding, filters, and detector settings.</p>
<p>5a: Ensure all configurations meet requirements.</p>
<p>6a: Assign priority and allocate observation slots.</p>
<p>7a: Format for observatory control system, run simulations if
needed.</p>
<p>8a: Confirm program readiness and compliance.</p>
<p>9a: Send to the system for execution.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exception Flows:</p>
<p>1b: If the validated science plan has issues, determine whether they
are minor or major.</p>
<ul>
<li><p>1c: If the issues are minor</p>
<ul>
<li><p>Request changes from the astronomer.</p></li>
<li><p>The astronomer resubmits the plan, and the process
restarts.</p></li>
</ul></li>
<li><p>1d: If the issues are major, reject the plan.</p></li>
</ul>
<p>3b: If issues are found in the observation sequences, check if they
can be fixed.</p>
<ul>
<li><p>3c: If feasible, modify the observation sequences and revalidate
them.</p></li>
<li><p>3d: If not feasible, the process stops.</p></li>
</ul>
<p>5b: If the selected instrument is unavailable, an alternate
instrument is selected.</p>
<p>5c: If the telescope is malfunctioning, determine if it can be
rescheduled.</p>
<ul>
<li><p>5d: If rescheduling is possible, wait for the telescope to
function and retry.</p></li>
<li><p>5e: If rescheduling is not possible, the process stops.</p></li>
</ul>
<p>6b: If there is a scheduling conflict during integration with the
scheduling system, adjust and reschedule.</p>
<p>7b: If errors occur while preparing for automated execution, optimize
settings and fix errors.</p>
<p>8b: If issues are found in the final review, fix them before
submitting.</p></td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./diagram/UC02_activity.png)

## **Sequence Diagram**

![](./diagram/UC02_sequence.png)


<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 23%" />
<col style="width: 41%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Control the Telescope via Command Line</td>
<td>ID: 03</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Telescope Operator</td>
<td>Use Case Type: User Initiated</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<p><strong>Telescope Operator:</strong> Needs to control the telescope
for observational and operational purposes using the command line
interface.</p>
<p><strong>Astronomer:</strong> Requires telescope control for executing
a science plan and gathering data.</p>
<p><strong>Science Observer:</strong> May rely on command-line control
for indirect telescope operations.</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Brief Description:</p>
<p>This use case describes how a telescope operator controls the
telescope using the command line to modify the location of the
telescope, set up observational parameters, and check that everything is
correctly implemented for making the astronomical observations.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger: The telescope operator initiates a
command-line session to control the telescope.</p>
<p>Type: User-Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Telescope Operator</p>
<p>Include:</p>
<p>Extend:</p>
<p>Generalization:</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<p>1. The telescope operator logs into the system.</p>
<p>2. The operator opens the command-line interface for telescope
control.</p>
<p>3. The system authenticates the user and provides access to control
commands.</p>
<p>4. The operator inputs commands to adjust the telescope's position
and configure settings.</p>
<p>5. The system executes the commands and provides real-time
feedback.</p>
<p>6. The telescope responds accordingly, adjusting to the specified
parameters.</p>
<p>7. The operator verifies the telescope’s response and makes any
necessary adjustments.</p>
<p>8. The operator completes the session and logs out of the
system.</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Sub flows:</p>
<p>4a: Operator requests the status of the telescope before making
adjustments.</p>
<p>7a: Operator saves the command logs for future reference.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exceptional Flow:</p>
<p>1b: If the system fails to authenticate the user, access is
denied.</p>
<p>2b: If an invalid command is entered, the system provides an error
message and suggests correct syntax.</p>
<p>4b: If the telescope fails to respond, the operator is notified of a
possible hardware or software issue.</p></td>
</tr>
</tbody>
</table>

##

## **Activity Diagram**

![](./diagram/UC03_activity.png)

## **Sequence Diagram**

![](./diagram/UC03_sequence.png)


<table>
<colgroup>
<col style="width: 33%" />
<col style="width: 33%" />
<col style="width: 33%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Control High-level Functions</td>
<td>ID: 04</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Administrator</td>
<td>Use Case Type: Essential</td>
</tr>
<tr class="odd">
<td colspan="3"><p>Stakeholders and Interests:</p>
<p><strong>Administrator:</strong> responsible to control and manage
high-level functions and systems</p>
<p><strong>Every users:</strong> need the roll granted by the high-level
functions to operate the systems</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Brief Description:</p>
<p>This case allows Administrators to control high-level functions,
including defining user access modes, managing users, and defining
operation levels.</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Trigger:</p>
<p>Type: User-Initiated</p></td>
</tr>
<tr class="even">
<td colspan="3"><p>Relationships:</p>
<p>Association: Administrator, Every users</p>
<p>Include:</p>
<p>Extend:Define user’s access mode, User Management, Define operation
level</p>
<p>Generalization:</p></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Normal Flow of Events:</p>
<ol type="1">
<li><p>Administrator logs into the system.</p></li>
<li><p>Administrator opens up the high-level feature control
panel.</p></li>
<li><p>Administrator selects the feature to operate/ control.</p></li>
<li><p>Administrator saves the configurations.</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="3"><p>Sub flows:</p>
<p>3a: Define User Access Modes:</p>
<ul>
<li><p>1a: Administrator selects "User Access Modes" from the control
panel.</p></li>
<li><p>2a: The system displays a list of current user access
modes.</p></li>
<li><p>3a: Administrator modifies the access modes as needed.</p></li>
<li><p>4a: Administrator confirms the changes.</p></li>
</ul>
<p>3b: Manage Users:</p>
<ul>
<li><p>1b: Administrator selects "Manage Users" from the control
panel.</p></li>
<li><p>2b: The system displays a list of current users.</p></li>
<li><p>3b: Administrator adds, removes, or updates user
information.</p></li>
<li><p>4b: Administrator confirms the changes.</p></li>
</ul>
<p>3c: Define Operational Levels:</p>
<ul>
<li><p>1c: Administrator selects "Operational Levels" from the control
panel.</p></li>
<li><p>2c: The system displays the current operational levels.</p></li>
<li><p>3c: Administrator modifies the operational levels as
needed</p></li>
<li><p>4c: Administrator confirms the changes.</p></li>
</ul></td>
</tr>
<tr class="odd">
<td colspan="3"><p>Alternate/Exceptional Flow:</p>
<p>AE1: If the system fails to authenticate the user, access is
denied.</p>
<p>AE2: If non-administrator attempt to access these features, the
system will deny the access.</p>
<p>AE3: If an administrator provides invalid form of inputs while
managing high-level features, the system will display error access and
deny the input.</p>
<p>AE4: if the system failed to save the configuration the system rolls
back the changes and shows the error logs.</p></td>
</tr>
</tbody>
</table>

## 

## **Activity Diagram**

![](./diagram/UC04_activity.png)

## **Sequence Diagram**

![](./diagram/UC04_sequence.png)

<table>
<colgroup>
<col style="width: 50%" />
<col style="width: 12%" />
<col style="width: 12%" />
<col style="width: 25%" />
</colgroup>
<tbody>
<tr class="odd">
<td>Use Case Name: Create a science plan</td>
<td colspan="2">ID: 05</td>
<td>Importance Level: High</td>
</tr>
<tr class="even">
<td colspan="2">Primary Actor: Astronomer</td>
<td colspan="2">Use Case Type: Essential</td>
</tr>
<tr class="odd">
<td colspan="4"><p>Stakeholders and Interests:</p>
<p><strong>Primary Actor:</strong></p>
<p>Astronomer wants to create, test, and submit a science plan
efficiently.</p>
<p><strong>Secondary Actors:</strong></p>
<p>Science Observe ensures the science plan is valid and executable.</p>
<p>Telescope Operator ensures the telescope and instruments are used
correctly.</p>
<p>Administrator oversees scheduling and system operations.</p>
<p>Support &amp; Developer Team maintaining system functionality and
fixing issues.</p></td>
</tr>
<tr class="even">
<td colspan="4">Brief Description: This use case describes how to create
a science plan.</td>
</tr>
<tr class="odd">
<td colspan="4"><p>Trigger:</p>
<ol type="1">
<li><p>A science plan submission might trigger a validation
process.</p></li>
<li><p>A weather change could trigger a rescheduling of the
observation.</p></li>
<li><p>A telescope error might trigger a diagnostic sequence.</p></li>
</ol>
<p>Type: Internal</p></td>
</tr>
<tr class="even">
<td colspan="4"><p>Relationships:</p>
<blockquote>
<p>Association: astronomer, science observer, operation staff</p>
<p>Include: create science plan -&gt; simulate science plan, validate
science plan -&gt; check instrument configuration</p>
<p>Extend: create science plan &lt;-&gt; modify science plan, validate
observing program &lt;-&gt; adjust program for scheduling conflicts.</p>
<p>Generalization: execute observing program -&gt; execute program with
adjustments</p>
</blockquote></td>
</tr>
<tr class="odd">
<td colspan="4"><p>Normal Flow Events:</p>
<ol type="1">
<li><p>The astronomer creates a science plan.</p></li>
<li><p>The astronomer submits the science plan.</p></li>
<li><p>Science Observer validates the science plan.</p></li>
<li><p>Operation staff transform the science plan into an observing
program.</p></li>
<li><p>Operation staff validate the observing program.</p></li>
<li><p>Science observer executes the observing program.</p></li>
<li><p>The astronomer collects and validates data.</p></li>
</ol></td>
</tr>
<tr class="even">
<td colspan="4"><p>Subflows:</p>
<p>1a. Use the virtual telescope to test feasibility.</p>
<p>2a. System checks for completeness.</p>
<p>3a: Observer checks instrument and schedule feasibility.</p>
<p>4a: Ensure compatibility with the observing queue.</p>
<p>5a: Validate telescope operation and safety.</p>
<p>6a: Monitor progress and adjust as needed.</p>
<p>7a: Ensure image quality and completeness.</p></td>
</tr>
<tr class="odd">
<td colspan="4"><p>Alternate/Exceptional Flow:</p>
<p>1b: Modify the plan if the simulation fails.</p>
<p>2b: Plan is rejected if details are missing.</p>
<p>3b: If conflicts exist, request plan revision.</p>
<p>4b: Adjust the program if scheduling conflicts arise.</p>
<p>5b: Reject the program if it risks system stability.</p>
<p>6b: Reschedule if interrupted by technical issues.</p>
<p>7b: If data is corrupt, schedule re-observation.</p></td>
</tr>
</tbody>
</table>

## **Activity Diagram**

![](./diagram/UC05_activity.png)

## **Sequence Diagram**

![](./diagram/UC05_sequence.png)

## **Class Diagram**
![](./diagram/ClassDiagram.png)
