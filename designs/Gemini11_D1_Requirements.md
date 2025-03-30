

---

### **Astronomers**
#### Functional Requirements:
1. Astronomers must be able to create detailed science plans using a virtual telescope interface or interactive observing modes.
2. The system must allow astronomers to create, upload, and manage observation proposals and detailed observation plans.

#### Non-Functional Requirements:
1. The system must handle the collection and processing of astronomical data during observations without delays, ensuring accurate and prompt data capture for analysis.
2. The system should ensure high availability, allowing astronomers to access observation tools with minimal downtime.

---

### **Science Observers**
#### Functional Requirements:
1. The system shall provide tools for science observers to review submitted science plans, ensuring they meet feasibility and operational requirements.

---

### **Telescope Operators**
#### Functional Requirements:
1. Provide a clear and accessible interface for telescope operators to execute and monitor telescope commands, with the ability to override scheduled commands when necessary.
2. The system must allow authorized users to schedule and control telescope operation, including configuring instruments, managing observation time slots, and adjusting telescope settings based on weather conditions.

#### Non-Functional Requirements:
1. The system should provide timeout mechanisms to handle responses. The timeout for acknowledgment is approximately 500 milliseconds.

---

### **Support Staff**
#### Functional Requirements:
1. Support Staff must be able to view system performance and status in real time to identify potential issues before they escalate.
2. Support Staff must be able to access critical controls to verify the system's functionality during diagnostics or maintenance.
3. Support Staff must be able to utilize test-level access to troubleshoot, validate, and resolve issues in subsystems.
4. Support Staff must be able to perform routine diagnostics and health checks on hardware and software subsystems.
5. Support Staff must be able to install new subsystems and configurations within the system, with an intuitive interface for managing installation procedures.
6. Support Staff must be able to update or reconfigure subsystems as necessary without disrupting operational schedules.

#### Non-Functional Requirements:
1. The system must respond to commands and queries quickly, particularly in Monitoring and Testing modes, where real-time diagnostics are critical.
2. The system’s timeouts for test commands and replies should be appropriately managed to avoid delays, with handshaking protocols responding within 100-200 milliseconds for critical operations.
3. The system must ensure uninterrupted functionality during fault conditions by isolating issues to specific subsystems, preventing broader system failures.

---

### **Administrators**
#### Functional Requirements:
1. Administrators must be able to schedule maintenance activities, ensuring they do not conflict with active observation schedules.

#### Non-Functional Requirements:
1. The system should ensure high availability, allowing administrators to access and manage system functions and schedules with minimal downtime.

---

### **Developer**
#### Functional Requirements:
1. Developers must be able to to access only the Maintenance and Test levels.
2. Developers must have permissions to operate in Monitoring and Testing modes.
3. Developers must be able to design, test, configure, and upgrade subsystems while ensuring that upgrades do not interfere with ongoing observations.
4. Developers must be able to access to test environments to perform integration and validation.
5. Developers must be able to install software upgrades and generate new system versions.
6. Developers must be able to intervene remotely or onsite to resolve major software issues.
7. Developer must be able to access from onsite locations, remote facilities, and partner institutions.

#### Non-Functional Requirements:
1. The system shall implement role-based access control (RBAC) to restrict Developer access to Maintenance and Test levels.
2. The system shall ensure that software upgrades and modifications do not interfere with ongoing observations.
3. The system shall support efficient software integration and validation within test environments.
4. Developers must follow strict configuration guidelines to prevent disruptions to normal operations.
5. The system shall provide secure remote access to Developers while maintaining high availability for intervention during critical issues.


### **All Users**
#### Functional Requirements:
1. Every user must log in to access the system.
2. The system must secure a login process with a Username and Password combination and Multi-factor Authentication.
3. Each user must be assigned to at least one of the three system operational access levels: Observing, Maintenance, and Test.
4. Each user must be able to access the system using at least one of six access modes: Observing, Monitoring, Operation, Planning, Testing, and Administrative.
5. Upon login, the system must determine the user’s role and grant access to appropriate access levels and modes. Available roles include Astronomers, Science Observers, Telescope Operators, Administrators, Developers, and Support Staff.
6. The system shall provide a drag-and-drop interface for building observing plans, utilizing predefined templates and visual aids such as target selection maps.
7. The system shall include a virtual telescope simulator to test and validate science plans before submission.
8. The system shall provide access to a real-time monitoring dashboard displaying metrics such as progress, weather conditions, and telescope position.
9. The system shall automatically generate and send notifications for significant events, including observation completion or delays.
10. The system shall provide a unified interface for loading, validating, and executing observing programs, with status indicators for tracking progress.

#### Non-Functional Requirements:
1. The system must be responsive and capable of handling high transaction loads, particularly in data acquisition and command processing.
2. The system must operate without disruptions under multi-user and multi-instrument contexts.
3. The system must have a simplified interface that focuses on ease of use while retaining all core functionalities.
4. The system must ensure only authorized users can submit commands or reconfigure systems, while others can view status or progress in read-only mode.
5. The system must provide separate workspaces for users to avoid conflicts, especially when accessing shared resources.
6. The system should prioritize actions based on user roles and their criticality.
7. Different user roles have specific privileges to access certain parts of the system.
8. The system should be designed to handle peak control information at 100 Transactions Per Second (TPS).
9. The user interface should focus on simplicity, efficiency, and safety.

