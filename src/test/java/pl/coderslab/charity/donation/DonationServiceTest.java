package pl.coderslab.charity.donation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.email.EmailBuilder;
import pl.coderslab.charity.email.EmailSender;
import pl.coderslab.charity.institution.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DonationServiceTest {

    @Mock
    private DonationRepository donationRepository;

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    DonationService donationService;


    @Test
    void shouldCountAllDonations() {
        // when
        donationService.numberOfDonations();
        // then
        verify(donationRepository).countAllDonations();
    }

    @Test
    void shouldCountAllBagsDonated() {
        //when
        donationService.numberOfBagsDonated();
        // then
        verify(donationRepository).countAllBagsGiven();
    }

    @Test
    void shouldSaveDonation() {
        // given
        Donation donation = new Donation();

        AppUser appUser = new AppUser();
        appUser.setEmail("test@email.org");
        appUser.setFirstName("Test");

        donation.setAppUser(appUser);

        donation.setCategories(List.of(new Category()));
        donation.setInstitution(new Institution());
        donation.setPickUpDate(LocalDate.of(2023, 12,12));
        donation.setPickUpTime(LocalTime.of(12, 0));

        String email = EmailBuilder.buildDonationSummaryEmail(donation);

        // when
        donationService.saveDonation(donation);

        // then
        verify(donationRepository).save(donation);
        verify(emailSender).send("test@email.org", "Charity - Potwierdzenie darowizny", email);
    }

    @Test
    public void testCountAllDonations() {
        // given
        Integer expectedCount = 10;
        when(donationRepository.countAllDonations()).thenReturn(expectedCount);

        // when
        Integer actualCount = donationRepository.countAllDonations();

        // then
        assertEquals(expectedCount, actualCount);
    }

}