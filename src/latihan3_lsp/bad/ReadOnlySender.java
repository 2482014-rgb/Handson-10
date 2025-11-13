package latihan3_lsp.bad;

public class ReadOnlySender extends NotificationSender {

    public ReadOnlySender() {
        super("READONLY");
    }

    @Override
    public boolean send(String recipient, String message) {
        throw new UnsupportedOperationException("This sender is read-only!");
    }
}

