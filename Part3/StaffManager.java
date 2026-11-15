import java.util.ArrayList;
import java.util.List;
/**
 *Class that manages all the Staff
 * @author Hannah Travis
 */
public class StaffManager {
    private List<Staff> staffList;

    /**
     * Constructor to initialize inital variables
     * @param staffList, list of staff
     */
    public StaffManager() {
        this.staffList = new ArrayList<>;
    }
    
    /**
     * Adds a staff to the list
     * @param staff, represents staff to add from staff class 
     */
    public void addStaff(Staff staff){
        this.staffList.add(staff);
    }
    
    /**
     * returns all stored Staff objects
     * @return 
     */
    public List<Staff> getAllStaff(){
        return this.staffList;
    }
    
    /**
     * Prints a numbered list for the staff
     */
    public void displayNumberedList(){
        for (int i = 0; i < this.staffList.size(); i++){
            System.out.println("Staff "+ (i + 1));
            this.staffList.get(i).displayInfo();
            System.out.println("-------------------------------"); 
        }
    }
    /**
     * Displays detailed info on all staff, un-numbered
     */
    public void displayAllStaff(){
        for(Staff s : staffList){
            System.out.println("--------------------------");
            s.displayInfo();
        }
        System.out.println("--------------------------");
    }
    
    
    
}
