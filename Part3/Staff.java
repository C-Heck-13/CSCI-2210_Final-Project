/**
 * Class that defines Staff
 * @author Hannah Travis
 * @author Edited by Connor Heck
 */
public class Staff extends User{
    
    private String role;
    private Manager supervisor;

    /**
     * Constructor to initalize all variables
     * @param role the staff member's role
     * @param supervisor the staff member's supervisor
     * @param id the staff member's system ID
     * @param name the staff member's name
     * @param phone the staff member's phone number
     */
    public Staff(String role, Manager supervisor, int id, String name, String phone) {
        super(id, name, phone);
        this.role = role;
        this.supervisor = supervisor;
    }

    /**
     * Gets the Staff Members role
     * @return 
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the Staff Members role
     * @param role string representing staffs job title
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * gets the supervisors info
     * @return returns supervisor name
     */
    public Manager getSupervisor() {
        return supervisor;
    }

    /**
     * Sets the supervisors name
     * @param supervisor  Represents m
     */
    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }
    
    /**
     * Updates statues of Maintenance Requests, calling set status in 
     * Maintenance Request class
     * @param request, requests to update
     * @param newStatus, the new status string
     */
    public void updateStatus(MaintenanceRequest request, String newStatus) {
        if (request != null) {
            request.setStatus(newStatus);
        }
    }
    /**
     * Overrides the display info in the super class to display
     * staff specific info
     */
    @Override
    public void displayInfo() {
        System.out.println("Staff ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Role: " + this.role);
        System.out.println("Supervisor: " + this.supervisor.getName());

    } 
}