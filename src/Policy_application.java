class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class PoorDrivingRecordException extends Exception {
    public PoorDrivingRecordException(String message) {
        super(message);
    }
}

class HealthIssueException extends Exception {
    public HealthIssueException(String message) {
        super(message);
    }
}

class PolicyApplication {
    public void validateApplication(int age, boolean hasBadDrivingRecord, boolean hasHealthIssue)
            throws InvalidAgeException, PoorDrivingRecordException, HealthIssueException {

        if (age < 18 || age > 70) {
            throw new InvalidAgeException("Invalid age: Applicant must be between 18 and 70.");
        }
        if (hasBadDrivingRecord) {
            throw new PoorDrivingRecordException("Application rejected due to poor driving record.");
        }
        if (hasHealthIssue) {
            throw new HealthIssueException("Application rejected due to health issues.");
        }

        System.out.println("Policy application approved ✅");
    }
}

// Main Test
public class Policy_application {
    public static void main(String[] args) {
        PolicyApplication app = new PolicyApplication();

        try {
            app.validateApplication(68, false, false);
        } catch (InvalidAgeException | PoorDrivingRecordException | HealthIssueException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

