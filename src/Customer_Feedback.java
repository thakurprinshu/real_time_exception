class FeedbackNotFoundException extends Exception {
    public FeedbackNotFoundException(String message) {
        super(message);
    }
}

class InvalidFeedbackContentException extends RuntimeException {
    public InvalidFeedbackContentException(String message) {
        super(message);
    }
}

class CustomerFeedbackSystem {
    private java.util.Map<Integer, String> feedbacks = new java.util.HashMap<>();

    public void submitFeedback(int id, String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            throw new InvalidFeedbackContentException("Feedback cannot be empty!");
        }
        feedbacks.put(id, feedback);
        System.out.println("Feedback submitted: " + feedback);
    }

    public String getFeedback(int id) throws FeedbackNotFoundException {
        if (!feedbacks.containsKey(id)) {
            throw new FeedbackNotFoundException("Feedback with ID " + id + " not found!");
        }
        return feedbacks.get(id);
    }
}

public class Customer_Feedback {
    public static void main(String[] args) {
        CustomerFeedbackSystem system = new CustomerFeedbackSystem();

        try {
            system.submitFeedback(1, "Service was great!");
            System.out.println(system.getFeedback(2));
        } catch (FeedbackNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InvalidFeedbackContentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
