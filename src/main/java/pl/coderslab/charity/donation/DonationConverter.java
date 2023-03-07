package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DonationConverter implements Converter<String, Donation> {
    private final DonationService donationService;

    @Autowired
    public DonationConverter(DonationService donationService) {
        this.donationService = donationService;
    }

    @Override
    public Donation convert(String source) {
        return donationService.findById(Long.parseLong(source));
    }
}