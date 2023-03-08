package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public Donation findById(Long id) {
        return donationRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public Integer numberOfDonations() {
        return donationRepository.countAllDonations().orElse(0);
    }

    public Integer numberOfBagsDonated() {
        Integer numberOfBags = donationRepository.countAllBagsGiven();
        if (numberOfBags == null) {
            return 0;
        }
        return numberOfBags;
    }


}
