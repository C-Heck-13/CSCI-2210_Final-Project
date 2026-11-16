import java.util.ArrayList;

/**
 * This class defines Manager objects in the system. Subclass of User
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class Manager extends User {
    private String email;
    private ArrayList<Staff> staffList;

    /**
     * Constructor method - sets the initial values of the Manager
     * @param id the system ID of the manager
     * @param name the manager's name
     * @param phone the manager's phone number
     * @param email the manager's email
     */
    public Manager(int id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
        this.staffList = new ArrayList<>();
    }

    /**
     * Getter method - retrieves the manager's email
     * @return email the manager's email
     */
    public String getEmail() { 
        return email; 
    }
    
    /**
     * Setter method - updates the manager's email
     * @param email the updated email address
     */
    public void setEmail(String email) { 
        this.email = email; 
    }

    /**
     * Assigns a maintenance request to a staff member
     * @param request the request to be assigned
     * @param staff the staff member the request is to be assigned to
     */
    public void assignRequest(MaintenanceRequest request, Staff staff) {
        request.setAssignedStaff(staff);
        staff.updateStatus(request, "Assigned");
    }

    /**
     * Adds a new staff member to the system
     * @param staff the staff member to be added
     */
    public void addStaff(Staff staff) {
        staff.setSupervisor(this);
        staffList.add(staff);
    }

    /**
     * Gets the list of all active staff in the system
     * @return staffList the list of staff
     */
    public ArrayList<Staff> getStaffList() { 
        return staffList; 
    }

    /**
     * This method sets the status of a maintenance request to closed
     * @param request 
     */
    public void closeRequest(MaintenanceRequest request) {
        request.setStatus("Closed");
    }

    /**
     * This method displays the manager's information
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Email: " + email);
    }
}