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

    public Integer numberOfDonations() {
        Integer numberOfDonations = donationRepository.countAllDonations();
        if (numberOfDonations == null) {
            return 0;
        }
        return numberOfDonations;
    }

    public Integer numberOfBagsDonated() {
        Integer numberOfBags = donationRepository.countAllBagsGiven();
        if (numberOfBags == null) {
            return 0;
        }
        return numberOfBags;
    }


}
