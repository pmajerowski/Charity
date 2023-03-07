package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/form")
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/")
    public String displayForm(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }

    @PostMapping
    public String saveDonation(@RequestBody Donation donation) {
        donationService.saveDonation(donation);
        return "redirect:form-confirmation";
    }


    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionService.getAllInstitutions();
    }
}
