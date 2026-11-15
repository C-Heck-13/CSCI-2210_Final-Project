// Justin Villegas
import java.util.ArrayList;

public class Manager extends User {
    private String email;
    private ArrayList<Staff> staffList;

    public Manager(int id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
        this.staffList = new ArrayList<>();
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void assignRequest(MaintenanceRequest request, Staff staff) {
        staff.updateStatus(request, "Assigned");
    }

    public void addStaff(Staff staff) {
        staff.setSupervisor(this);
        staffList.add(staff);
    }

    public ArrayList<Staff> getStaffList() { return staffList; }

    public void closeRequest(MaintenanceRequest request) {
        request.setStatus("Closed");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Email: " + email);
    }
}
