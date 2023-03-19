package pl.coderslab.charity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class CharityApplicationIntegrationTest extends AbstractIntegrationTest {



    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNewView() throws Exception {
        System.out.println(mySQLContainer.getJdbcUrl());
        System.out.println(mySQLContainer.getUsername());
        System.out.println(mySQLContainer.getDatabaseName());
        System.out.println(mySQLContainer.getPassword());

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("institutions"))
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldTest() {

    }
}
