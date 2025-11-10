package latihan1_srp.good;

public class NotificationService {

    private MessageValidator validator;
    private MessageFormatter formatter;
    private EmailSender emailSender;
    private SmsSender smsSender;
    private NotificationLogger logger;
    private NotificationRepository repository;

    public NotificationService(MessageValidator validator,
                               MessageFormatter formatter,
                               EmailSender emailSender,
                               SmsSender smsSender,
                               NotificationLogger logger,
                               NotificationRepository repository) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    public void sendNotification(String message, String type, String recipient) {

        validator.validate(message);

        String formattedMessage = formatter.format(message);

        if (type.equals("EMAIL")) {
            emailSender.send(recipient, formattedMessage);
        } else if (type.equals("SMS")) {
            smsSender.send(recipient, formattedMessage);
        }

        logger.log(type, recipient);

        repository.save(type, recipient, formattedMessage);
    }
}


