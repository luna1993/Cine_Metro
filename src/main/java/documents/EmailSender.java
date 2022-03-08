package documents;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSender {
    static final String SENDER_EMAIL = "CineMetroKA@gmail.com";
    static final String SENDER_PASSWORD = "";
    static final String SMTP_GMAIL_COM = "smtp.gmail.com";
    static final String GMAIL_SMTP_PORT = "587";

    @Getter @Setter
    private File file;

    public boolean sendEmail(String receiverEmail, String subject, String messageText){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_GMAIL_COM);
        props.put("mail.smtp.port", GMAIL_SMTP_PORT);

        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(SENDER_EMAIL));
            message.setSubject(subject);

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(messageText);

            MimeBodyPart fileBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            DataSource source = new FileDataSource(file);
            fileBodyPart.setDataHandler(new DataHandler(source));
            fileBodyPart.setFileName(file.getName());
            multipart.addBodyPart(textBodyPart);
            multipart.addBodyPart(fileBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
        }
    }
}