package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.security.Principal;
import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final AppUserService appUserService;

    @RequestMapping("/")
    public String homeAction(Model model, Principal principal) {
        if (null != principal) {
            AppUser appUser = appUserService.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("user", appUser);
        }

        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutions", institutions);

        model.addAttribute("donationsNumber", donationService.numberOfDonations());
        model.addAttribute("bagsDonated", donationService.numberOfBagsDonated());

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
