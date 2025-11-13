package latihan3_lsp.good;

public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    // Clear contract: tidak boleh lempar exception
    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}

