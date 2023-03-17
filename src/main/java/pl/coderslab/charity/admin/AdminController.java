package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AppUserService appUserService;

    private final InstitutionService institutionService;

    @GetMapping("/index")
    public String landingPageAdmin(Model model, Principal principal) {
        if (null != principal) {
            AppUser appUser = appUserService.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("user", appUser);
        }
        return "index_admin";
    }

    @GetMapping("/institutions")
    public String institutionsPage(Model model, Principal principal) {
        if (null != principal) {
            AppUser appUser = appUserService.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("user", appUser);
        }
        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutions", institutions);

        return "institutions";
    }
}
