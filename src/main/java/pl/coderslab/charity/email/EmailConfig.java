package pl.coderslab.charity.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender(CredentialsProvider credentialsProvider) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties props = mailSender.getJavaMailProperties();

        if (credentialsProvider.areCredentialsConfigured()) {
            String password = credentialsProvider.getPassword();
            String email = credentialsProvider.getEmail();
            String host = credentialsProvider.getHostName();
            String port = credentialsProvider.getPort();

            mailSender.setHost(host);
            mailSender.setPort(Integer.parseInt(port));
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

