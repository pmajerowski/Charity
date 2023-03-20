package pl.coderslab.charity.email;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="email-configuration.enabled",
        havingValue = "false",
        matchIfMissing = true
)
public class EmailNoCredentialsService implements EmailSender {

    @Override
    public void send(String to, String subject, String email) {

    }
}
