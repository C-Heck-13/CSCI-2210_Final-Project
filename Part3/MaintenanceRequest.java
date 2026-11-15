/**
* Class that defines MaintenanceRequest
* author: Hannah Travis
*/
public class MaintenanceRequest {
    private Property address;
    private String dateOfRequest;
    private String status;
    private String issue;
    private Staff assignedStaff;
    
    /**
     * Constructor to initalize values
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
        System.out.println("Property Address: " + this.address);
        System.out.println("Date Requested: " + this.dateOfRequest);
        System.out.println("Status: " + this.status);
        System.out.println("Issue: " + this.issue);
        System.out.println("Assigned Staff:   " + (assignedStaff != null ? assignedStaff.getRole() : "Unassigned"));
        System.out.println("=========================================");
    }

    /**
     * Gets the date the request was made
     * @return 
     */
    public String getDateOfRequest() {
        return dateOfRequest;
    }

    /**
     * Gets the Status 
     * @return 
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the Issue
     * @return 
     */
    public String getIssue() {
        return issue;
    }

    /** 
     * gets the assigned staff
     * @return 
     */
    public Staff getAssignedStaff() {
        return assignedStaff;
    }

    /**
     * sets the assinged staff
     * @param assignedStaff 
     */
    public void setAssignedStaff(Staff assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
    
    /**
     * Sets the date the request was submitted
     * @param DateOfRequest 
     */
    public void setDateOfRequest(String DateOfRequest) {
        this.dateOfRequest = DateOfRequest;
    }

    /**
     * Sets the status 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Issue is set by the user
     * @param issue 
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }
    
    
}
