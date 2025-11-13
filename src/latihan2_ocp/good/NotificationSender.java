package latihan2_ocp.good;

// Interface untuk semua sender
public interface NotificationSender {
    void send(String recipient, String message);
    String getType();
}
