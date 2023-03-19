package pl.coderslab.charity;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public abstract class AbstractIntegrationTest {


    public static MySQLContainer mySQLContainer =
            new MySQLContainer("mysql:latest")
                    .withUsername("test")
                    .withPassword("test")
                    .withDatabaseName("test");

    static {
        mySQLContainer.start();
    }

    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {
        registry.add("test", mySQLContainer::getJdbcUrl);
        registry.add("test", mySQLContainer::getUsername);
        registry.add("test", mySQLContainer::getPassword);
    }
}
