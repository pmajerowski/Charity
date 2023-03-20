package pl.coderslab.charity.email;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(CredentialsNotPresent.class)
@NoArgsConstructor
public class EmailNoCredentialsService implements EmailSender {


    @Override
    public void send(String to, String subject, String email) {

    }
}
