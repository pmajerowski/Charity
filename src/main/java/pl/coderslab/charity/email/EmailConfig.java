package pl.coderslab.charity.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender(CredentialsConfiguration config) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties props = mailSender.getJavaMailProperties();

        if (config.areCredentialsConfigured()) {
            String password = config.getPassword();
            String email = config.getEmail();
            String host = config.getHostName();
            int port = config.getPort();

            mailSender.setHost(host);
            mailSender.setPort(port);
            mailSender.setUsername(email);
            mailSender.setPassword(password);

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.enable", "false");

        } else {
            props.put("mail.smtp.auth", "false");
        }

        return mailSender;
    }
}
