package latihan1_srp;

// import only the good package classes for convenience
import latihan1_srp.good.*;

public class SRPPractice {
    public static void main(String[] args) {
        // ===== PART 1: BAD PRACTICE - Melanggar SRP =====
        System.out.println("=== BAD PRACTICE: Melanggar SRP ===\n");

        // Use fully-qualified name for the bad implementation to avoid ambiguity
        latihan1_srp.bad.NotificationService badService = new latihan1_srp.bad.NotificationService();
        badService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("NotificationService memiliki TERLALU BANYAK tanggung jawab:");
        System.out.println("1. Validasi message");
        System.out.println("2. Format message");
        System.out.println("3. Kirim via EMAIL");
        System.out.println("4. Kirim via SMS");
        System.out.println("5. Logging");
        System.out.println("6. Simpan ke database");
        System.out.println("\nSatu class, BANYAK alasan untuk berubah = MELANGGAR SRP!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti SRP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti SRP ===\n");

        // create good components (these are in latihan1_srp.good so import worked)
        MessageValidator validator = new MessageValidator();
        MessageFormatter formatter = new MessageFormatter();
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        NotificationLogger logger = new NotificationLogger();
        NotificationRepository repository = new NotificationRepository();

        // use the good NotificationService (simple name refers to latihan1_srp.good.NotificationService)
        NotificationService goodService = new NotificationService(
                validator, formatter, emailSender, smsSender, logger, repository
        );

        goodService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Easy to understand - Setiap class punya fokus jelas");
        System.out.println("✓ Easy to test - Bisa test setiap komponen terpisah");
        System.out.println("✓ Easy to maintain - Perubahan di satu area tidak affect yang lain");
        System.out.println("✓ Reusable - MessageFormatter bisa dipakai di tempat lain");
        System.out.println("✓ Low coupling - Komponen tidak saling bergantung berlebihan");
    }
}
