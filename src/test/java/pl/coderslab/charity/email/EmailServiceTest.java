package pl.coderslab.charity.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private MimeMessage mimeMessage;

    @Mock
    private MimeMessageHelper mimeMessageHelper;

    @Mock
    private CredentialsConfiguration credentialsConfiguration;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSend() throws Exception {
        // given
        lenient().when(credentialsConfiguration.getPassword()).thenReturn("pass");
        lenient().when(credentialsConfiguration.getEmail()).thenReturn("email");

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
