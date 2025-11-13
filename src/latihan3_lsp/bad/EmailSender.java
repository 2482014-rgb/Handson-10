package latihan3_lsp.bad;

public class EmailSender extends NotificationSender {

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        System.out.println("✓ Notification sent via EMAIL to " + recipient);
        return true;
    }
}

