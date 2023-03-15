package pl.coderslab.charity.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private MimeMessage mimeMessage;

    @Mock
    private MimeMessageHelper mimeMessageHelper;

    @Test
    public void testSend() throws Exception {
        // given
        String to = "john@example.com";
        String subject = "Test email";
        String email = "Hello, this is a test email.";
        EmailService emailService = new EmailService(mailSender);

        MimeMessage message = mailSender.createMimeMessage();
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(email);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // when
        emailService.send(to, subject, email);

        // then
        verify(mailSender, times(1)).send(mimeMessage);
    }
}
