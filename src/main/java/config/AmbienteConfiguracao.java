package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmbienteConfiguracao {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USER}")
    private String databaseUser;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    @Value("${PORT}")
    private int port;

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public int getPort() {
        return port;
    }
}
