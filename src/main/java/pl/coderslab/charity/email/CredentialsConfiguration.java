package pl.coderslab.charity.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("email-configuration")
public class CredentialsConfiguration {

    private String email;
    private String password;
    private String hostName;
    private int port;
    private boolean enabled;

    public boolean areCredentialsConfigured() {
        return (email != null && password != null) && enabled;
    }
}
