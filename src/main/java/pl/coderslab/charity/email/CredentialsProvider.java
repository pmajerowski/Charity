package pl.coderslab.charity.email;

import org.springframework.stereotype.Service;

@Service
public class CredentialsProvider {

    private static final String EMAIL = "EMAIL";
    private static final String EMAIL_PASSWORD = "EMAIL_PASSWORD";
    private static final String HOST_NAME = "HOST_NAME";
    private static final String PORT = "PORT";

    public String getEmail() {
        String email = System.getenv(EMAIL);
        return email;
    }

    public String getPassword() {
        String password = System.getenv(EMAIL_PASSWORD);
        return password;
    }

    public String getHostName() {
        return System.getenv(HOST_NAME);
    }

    public String getPort() {
        String port = System.getenv(PORT);
        return port;
    }

    public boolean areCredentialsConfigured() {
        return getEmail() != null || getPassword() != null;
    }


}
