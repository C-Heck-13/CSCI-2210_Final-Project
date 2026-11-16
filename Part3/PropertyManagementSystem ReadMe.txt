PropertyManagementSystem ReadMe:

Required Classes:
- PropertyManagementSystem.java (Contains main method)
- Menu.java
- MainMenu.java
- ManagerSubMenu.java
- ManagerOptions.java
- Manager.java
- ManagerManager.java
- StaffSubMenu.java
- StaffOptions.java
- Staff.java
- StaffManager.java
- TenantSubMenu.java
- TenantOptions.java
- Tenant.java
- TenantManager.java
- CustomerFeedback.java
- CustomerFeedbackManager.java
- LeaseManager.java
- Lease.java
- Property.java
- PropertyManager.java
- Rent.java
- User.java
- MaintenanceRequest.java
- MaintenanceRequestManager.java

Compilation Instructions:
	Command Line prompt: javac PropertyManagementSystem.java

Running Instructions: 
	Command Line Prompt: java PropertyManagementSystem

The program will provide menus. Follow the options to perform program functions.
Entry of 4 on the main menu will exit the program.

Important note:
	A default admin manager will be created initially to access Manager functions. In 	order to access Staff and Tenant functions:

		Staff: In the main Manager menu, select Option "7. Add New Staff Member", 		follow the prompts, then return to the main menu and access the Staff 			Submenu. Your created staff member will show up for log-on.
	
		Tenant: From the Manager Submenu, select option "3. Add a Property", 			follow the prompts, then upon return to the Manager menu, select option 		"8. Create a new lease". Following these prompts (requiring an address to 		have been made) will create a new Tenant in the system. Upon return to 			the Manager menu, return to the Main menu and access the Tenant menu. 			Your created Tenant will be available for log-on.