package pl.coderslab.charity.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;
    private final CredentialsProvider credentialsProvider;

    @Override
    @Async
    public void send(String to, String subject, String email) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            buildHelper(to, subject, email, mimeMessage);

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            LOGGER.debug("Specify email sending credentials");

        }
    }

    private MimeMessageHelper buildHelper(String to, String subject, String email, MimeMessage mimeMessage) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(credentialsProvider.getEmail());

            return helper;

        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}

