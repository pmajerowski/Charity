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
        if (email == null) {
            return "test@email.org";
        }
        return email;
    }

    public String getPassword() {
        String password = System.getenv(EMAIL_PASSWORD);
        if (password == null) {
            return "password";
        }
        return password;
    }

    public String getHostName() {
        String hostName = System.getenv(HOST_NAME);
        if (hostName == null) {
            return "hostname";
        }
        return hostName;
    }

    public String getPort() {
        String port = System.getenv(PORT);
        if (port == null) {
            return "0";
        }
        return port;
    }

    public boolean areCredentialsConfigured() {
        return System.getenv(EMAIL) != null || System.getenv(EMAIL_PASSWORD) != null;
    }


}
