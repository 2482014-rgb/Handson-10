package latihan1_srp.good;

public class MessageValidator {

    public void validate(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        System.out.println("[Validator] Message validated successfully");
    }
}
