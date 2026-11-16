import java.util.ArrayList;

/**
 * This class serves as a manager class for multiple customer feedback items
 * @author Connor Heck
 * Created on 11/12/26
 */
public class CustomerFeedbackManager {
    private ArrayList<CustomerFeedback> feedbackList;

    /**
     * Constructor Class - Initializes the array list for collection of feedbacks
     */
    public CustomerFeedbackManager() {
        feedbackList = new ArrayList<>();
    }

    /**
     * This method adds a customer's feeedback to the array list
     * @param feedback
     */
    public void addFeedback(CustomerFeedback feedback) {
        feedbackList.add(feedback);
    }

    /**
     * This method calculates the average rating across the tenant-submitted feedbacks
     * @return avgRating the average rating of the feedbacks
     */
    public float getAverageRating() {
        float avgRating;

        if(feedbackList.size() == 0) {
            System.out.println("Cannot calculate average - No feedback at this time.");
            avgRating = 0;
            return avgRating;
        }
        else {
        int sum = 0;

            for(CustomerFeedback feedback : feedbackList) {
             sum += feedback.getRating();
            }

            avgRating = (float)sum / feedbackList.size();

            return avgRating;
        }
    }

    /**
     * This method generates a report of the submitted feedbacks. If the list is empty, generates
     * a message accordingly.
     */
    public void getFullReport() {
        if(feedbackList.size() == 0) {
            System.out.println("No feedback to display at this time");
        }
        else {
            int lineCount = 1;
            System.out.println("~~~~~Full Manager Feedback Report~~~~~");
            System.out.printf("Average Rating: %.2f\n", getAverageRating());
            System.out.println("Tenant Comments: ");
            for(CustomerFeedback feedback : feedbackList) {
                System.out.print(lineCount + ". ");
                System.out.print("Rating: " + feedback.getRating() + " ");
                System.out.print("Comments: " + feedback.getFeedback() + "\n");
                lineCount++;
            }
            System.out.println("~~~~~~~~~~~~~End of Report~~~~~~~~~~~~~");
        }
    }
}
