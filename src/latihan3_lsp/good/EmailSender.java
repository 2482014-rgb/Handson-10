package latihan3_lsp.good;

public class EmailSender extends NotificationSender {

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        if (recipient == null || message == null) return false;
        System.out.println("[EmailSender] ✓ Notification sent to: " + recipient);
        return true;
    }
}
