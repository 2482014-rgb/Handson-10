package latihan3_lsp;

import latihan3_lsp.bad.NotificationSender;
import latihan3_lsp.bad.EmailSender;
import latihan3_lsp.bad.ReadOnlySender;
// import latihan3_lsp.good.*; // Uncomment nanti

public class LSPPractice {
    public static void main(String[] args) {

        // ===== BAD PRACTICE =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        NotificationSender sender1 = new EmailSender();
        NotificationSender sender2 = new ReadOnlySender(); // bermasalah

        System.out.println("Testing EmailSender:");
        processNotification(sender1, "user@example.com", "Hello");

        System.out.println("\nTesting ReadOnlySender:");
        try {
            processNotification(sender2, "user@example.com", "Hello");
        } catch (Exception e) {
            System.out.println("❌ Exception thrown: " + e.getClass().getSimpleName() +
                    ": " + e.getMessage());
            System.out.println("❌ Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent promise bisa kirim notifikasi");
        System.out.println("2. ReadOnlySender melempar exception");
        System.out.println("3. Tidak bisa menggantikan parent dengan aman");

        System.out.println("\n" + "=".repeat(70));

        // ===== GOOD PRACTICE =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        // UNCOMMENT SETELAH FILE GOOD SELESAI
        /*
        NotificationSender goodSender1 = new EmailSender();
        NotificationSender goodSender2 = new SmsSender();

        testSender(goodSender1, "user@example.com", "Hello");
        testSender(goodSender2, "081234567890", "Hello");
        */
    }

    private static void processNotification(NotificationSender sender,
                                            String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent successfully");
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }

    /*
    private static void testSender(NotificationSender sender,
                                   String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("  → Success!");
        }
    }
    */
}
