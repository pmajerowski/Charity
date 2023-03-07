package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }


}
