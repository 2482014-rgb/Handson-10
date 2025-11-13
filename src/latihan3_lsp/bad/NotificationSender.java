package latihan3_lsp.bad;

public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}
