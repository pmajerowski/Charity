package pl.coderslab.charity.appuser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserService underTest;

    @Test
    void shouldReturnCorrectUserByEmail() {
        // given
        String email = "test@example.com";
        AppUser expectedUser = new AppUser();
        expectedUser.setEmail(email);
        when(appUserRepository.findByEmail(email)).thenReturn(Optional.of(expectedUser));

        // when
        Optional<AppUser> actualUser = underTest.findByEmail(email);

        // then
        assertEquals(expectedUser, actualUser.get());
    }

    @Test
    void shouldEnableUser() {
        // given
        String email = "test@example.com";

        // when
        underTest.enableAppUser(email);

        // then
        verify(appUserRepository).enableAppUser(email);
    }

    @Test
    void shouldFindUserById() {
        // given
        Long id = 5L;
        //when
        underTest.findById(id);
        // then
        verify(appUserRepository).findById(id);
    }

    @Test
    void shouldFindUserByEmail() {
        // given
        String email = "test@email.com";
        //when
        underTest.findByEmail(email);
        // then
        verify(appUserRepository).findByEmail(email);
    }

    @Test
    void shouldSaveUser() {
        // given
        AppUser appUser = new AppUser();
        // when
        underTest.saveUser(appUser);
        // then
        verify(appUserRepository).save(appUser);
    }
}
