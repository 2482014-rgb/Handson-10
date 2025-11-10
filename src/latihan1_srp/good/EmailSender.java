package latihan1_srp.good;

public class EmailSender {

    public void send(String recipient, String message) {
        System.out.println("[EmailSender] Sending EMAIL to: " + recipient);
        System.out.println("[EmailSender] Content: " + message);
    }
}
