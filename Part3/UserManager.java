package propertymanager;

import java.util.ArrayList;
/**
 * This class creates an ArrayList and manages a collection of Users,
 * including any types that inherit from the class
 * @author connor.heck
 */
public class UserManager {
    private ArrayList<User> users;
    
    /**
     * Constructor method - initializes the ArrayList of users
     */
    public UserManager() {
        users = new ArrayList<>();
    }
    
    /**
     * This method adds a new user to the list
     * @param user an object of User class to be added 
     */
    public void addUser(User user) {
        users.add(user);
    }
    
    /**
     * This method removes a user from the list
     * @param user an object of User class to be removed
     */
    public void removeUser(User user) {
        users.remove(user);
    }
    
    /**
     * Uses the displayInfo of the User class to print and display user data
     */
    public void displayUsers() {
        if(users.size() == 0) {
            System.out.println("No active users to display");
        }
        else {
            for(User user : users) {
                user.displayInfo();
             }
        }
    }
}
