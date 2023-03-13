package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.email.EmailSender;

import java.util.List;

import static pl.coderslab.charity.email.EmailBuilder.buildDonationSummaryEmail;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    private final EmailSender emailSender;

    public Donation findById(Long id) {
        return donationRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public void sendConfirmationEmail(Donation donation){
        String to = donation.getAppUser().getEmail();
        String subject = "Charity - Potwierdzenie darowizny";
        String email = buildDonationSummaryEmail(donation);

        emailSender.send(to, subject, email);
    }

}
