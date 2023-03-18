package pl.coderslab.charity.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Mock
    private CredentialsProvider credentialsProvider;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSend() throws Exception {
        // given
        lenient().when(credentialsProvider.getPassword()).thenReturn("pass");
        lenient().when(credentialsProvider.getEmail()).thenReturn("email");

        String to = "john@example.com";
        String subject = "Test email";
        String email = "Hello, this is a test email.";

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
