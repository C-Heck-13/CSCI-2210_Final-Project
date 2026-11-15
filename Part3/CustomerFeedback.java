public class CustomerFeedback {
    
    private int rating;
    private String feedback;
    private CustomerFeedbackManager feedbackManager;
    

    /**
     * Constructor Method - This method initializes the manager class object
     */
    public CustomerFeedback() {
        feedbackManager = new CustomerFeedbackManager();
    }

    /**
     * Constructor method - Sets the initial values of the feedback 
     * @param rating the rating value of the feedback
     * @param feedback the comment description
     */
    public CustomerFeedback(int rating, String feedback) {
        this();
        this.rating = rating;
        this.feedback = feedback;
    }

    /**
     * Getter method - retrieves the rating value of the feedback
     * @return rating the customer's rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * getter method - retrieves the feedback comment 
     * @return feedback the customer's comment
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Setter method - updates the rating value
     * @param rating the rating value to update to 
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Setter method - updates the feedback comment
     * @param feedback the new comment to update to
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Uses the manager class's getAverageRating to calculate the average rating 
     * @return the average rating of collected feedback
     */
    public float getAverageRating() {
        return feedbackManager.getAverageRating();

    }

    /**
     * Uses the manager class to generate a full report of the feedback.
     */
    public void getFullReport() {
        feedbackManager.getFullReport();
    }
}
