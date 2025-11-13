package latihan2_ocp.bad;

public class NotificationService {
    public void sendNotification(String message, String type, String recipient) {
        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + message);
        }
    }
}

