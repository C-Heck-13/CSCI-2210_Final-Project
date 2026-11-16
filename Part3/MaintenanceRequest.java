/**
* Class that defines MaintenanceRequest
* author: Hannah Travis
* Edited by Connor Heck
*/
public class MaintenanceRequest {
    private Property address;
    private String dateOfRequest;
    private String status;
    private String issue;
    private Staff assignedStaff;
    
    /**
     * Constructor to initialize values
     * @param address, the address of the property
     * @param DateOfRequest, the date the request was made
     * @param status, the status of the issue
     * @param issue , description of the issue
     */
    public MaintenanceRequest(Property address, String DateOfRequest, String status, String issue) {
        this.address = address;
        this.dateOfRequest = DateOfRequest;
        this.status = status;
        this.issue = issue;
    }
    
    /**
     * Prints the information for the maintenance requests
     */
    public void displayMaintenanceReqInfo(){
        System.out.println("=========================================");
        System.out.println("          MAINTENANCE REQUEST            ");
        System.out.println("=========================================");
        System.out.println("Property Address: " + this.address.getAddress());
        System.out.println("Date Requested: " + this.dateOfRequest);
        System.out.println("Status: " + this.status);
        System.out.println("Issue: " + this.issue);
        System.out.println("Assigned Staff:   " + (assignedStaff != null ? assignedStaff.getName() : "Unassigned"));
        System.out.println("=========================================");
    }

    /**
     * Gets the date the request was made
     * @return dateOfRequest the date of request submission
     */
    public String getDateOfRequest() {
        return dateOfRequest;
    }

    /**
     * Gets the Status 
     * @return status the status of the Maintenance request
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the Issue
     * @return issue the problem brought up by the Tenant
     */
    public String getIssue() {
        return issue;
    }

    /** 
     * gets the assigned staff
     * @return assignedStaff the staff member assigned to complete the request
     */
    public Staff getAssignedStaff() {
        return assignedStaff;
    }

    /**
     * sets the assinged staff
     * @param assignedStaff the staff member to be assigned to the request
     */
    public void setAssignedStaff(Staff assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
    
    /**
     * Sets the date the request was submitted
     * @param DateOfRequest the date of the request's submission
     */
    public void setDateOfRequest(String DateOfRequest) {
        this.dateOfRequest = DateOfRequest;
    }

    /**
     * Sets the status 
     * @param status the status of the request
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Issue is set by the user
     * @param issue the problem the request is being submitted for
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }
    
    
}