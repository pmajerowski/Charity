package pl.coderslab.charity.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserRepositoryIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private InstitutionRepository institutionRepository;



    @Test
    public void givenEndpointURL_ShouldGet200ResponseAndView() throws Exception {

        List<Institution> institutions = institutionRepository.findAll();
        // when // then
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("institutions"))
                .andExpect(model().attribute("institutions", institutions))
                .andExpect(view().name("index"));
    }

    @Test
    @Transactional
    public void givenUsersInDB_WhenUpdateEmailForName_ThenModifyMatchingUsers(){
        // given
        insertUsers();
        // when
        int updatedUsersEmail = userRepository.updateUserSetEmailForName("changed@example.com", "SAMPLE");
        // then
        assertThat(updatedUsersEmail).isEqualTo(2);
    }

    @Test
    public void givenUsersInDB_WhenFindByEmail_ThenShouldReturnMatchingUser() {
        // given
        insertUsers();
        // when
        Optional<AppUser> userByEmail = userRepository.findByEmail("email4@example.com");
        // then
        assertThat(userByEmail).isPresent();
        assertThat(userByEmail.get().getFirstName()).isEqualTo("SAMPLE4");
    }

    @Test
    public void shouldRedirectToLoginPage() throws Exception {
        this.mockMvc.perform(get("/form"))
                .andExpect(redirectedUrl("http://localhost/login"));
    }


    private void insertUsers() {
        userRepository.save(new AppUser("SAMPLE", "email@example.com"));
        userRepository.save(new AppUser("SAMPLE2", "email2@example.com"));
        userRepository.save(new AppUser("SAMPLE", "email3@example.com"));
        userRepository.save(new AppUser("SAMPLE4", "email4@example.com"));
        userRepository.flush();
    }

}
