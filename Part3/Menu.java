/**
 * Interface class, setting contract of methods to be utilized by 
 * MainMenu, ManagerSubMenu, StaffSubMenu, and TenantSubMenu classes.
 * @author Connor Heck
 * Created on 11/3/26
 */
public interface Menu {
    
    void showMenu();
    void displayOptions();
    void processOption(int selection);

}
