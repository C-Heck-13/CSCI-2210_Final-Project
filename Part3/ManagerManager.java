import java.util.ArrayList;

/**
 * This class serves as a manager class for objects of the Manager subclass of user
 * @author Connor Heck
 * created on 11/14/26
 */
public class ManagerManager {
    private ArrayList<Manager> managers;

    /**
     * Constructor method - Initializes storage of Managers
     */
    public ManagerManager() {
        managers = new ArrayList<>();
    }

    /**
     * This method adds a manager to the array list
     * @param manager the manager to be added
     */
    public void addManager(Manager manager) {
        managers.add(manager);
    }

    /**
     * This method removes a requested manager from the array list
     * @param manager the manager to be removed
     */
    public void removeManager(Manager manager) {

        managers.remove(manager);
    }

    /**
     * Retrieves a manager from the array list
     * @param selection the index value of the manager to be returned
     * @return the manager at the requested index value
     */
    public Manager getManager(int selection) {
        return managers.get(selection);
    }

    /**
     * This method retrieves a list of active managers
     * @return managers the list of managers
     */
    public ArrayList<Manager> getManagers() {
        return managers;
    }
}
