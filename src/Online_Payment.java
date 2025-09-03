// Custom Exceptions
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class InvalidPaymentDetailsException extends RuntimeException {
    public InvalidPaymentDetailsException(String message) {
        super(message);
    }
}

class PaymentProcessingSystem {
    public void processPayment(String cardNumber, double amount)
            throws PaymentFailedException {

        if (cardNumber == null || cardNumber.length() != 16) {
            throw new InvalidPaymentDetailsException("Invalid card details provided!");
        }
        if (amount <= 0) {
            throw new InvalidPaymentDetailsException("Invalid payment amount!");
        }

        if (amount > 10000) {
            throw new PaymentFailedException("Payment failed: Limit exceeded!");
        }

        System.out.println("Payment of $" + amount + " processed successfully ");
    }
}

public class Online_Payment {
    public static void main(String[] args) {
        PaymentProcessingSystem payment = new PaymentProcessingSystem();

        try {
            payment.processPayment("1234567890123456", 15000);
        } catch (PaymentFailedException e) {
            System.err.println("Transaction Error: " + e.getMessage());
        } catch (InvalidPaymentDetailsException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
