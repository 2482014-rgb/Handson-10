package latihan1_srp.bad;

public class NotificationService {

    public void sendNotification(String message, String type, String recipient) {

        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        String formattedMessage = message.toUpperCase() + " [SENT AT: "
                + System.currentTimeMillis() + "]";

        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        }

        System.out.println("LOG: Notification sent - Type: " + type);
        System.out.println("DB: Saving notification record...");
    }
}

