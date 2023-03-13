package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutions", institutions);

        List<Donation> donations = donationService.getAllDonations();
        int numberOfDonations = 0;
        int numberOfBagsDonated = 0;
        for(Donation donation : donations) {
            numberOfDonations ++;
            numberOfBagsDonated += donation.getQuantity();
        }

        model.addAttribute("donationsNumber", numberOfDonations);
        model.addAttribute("bagsDonated", numberOfBagsDonated);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
