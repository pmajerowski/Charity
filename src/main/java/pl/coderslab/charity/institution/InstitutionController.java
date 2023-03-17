package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/institution")
@AllArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/{institutionId}")
    @ResponseBody
    public Institution getInstitutionById(@PathVariable("institutionId") Long id) {
        return institutionService.findById(id);
    }

    @GetMapping("/add")
    public String addInstitutionForm() {
        return "institution_add";
    }

    @PostMapping
    public void addInstitution(@RequestBody Institution institution) {
        institutionService.saveInstitution(institution);
    }

    @GetMapping("/delete/{institutionId}")
    public String confirmInstitutionDelete(@PathVariable("institutionId") Long id, Model model) {
        model.addAttribute("institutionId", id);
        return "institution_delete_confirm";
    }

    @PostMapping( "/delete/{institutionId}")
    public String deleteInstitution(@PathVariable("institutionId") Long id) {
        Institution institution = institutionService.findById(id);
        institution.setIsActive(false);
        institutionService.updateInstitution(institution);
        return "redirect:/admin/institutions";
    }

    @PutMapping(path = "{institutionId}")
    public void updateInstitution(@PathVariable("institutionId") Long id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description) {
        institutionService.updateInstitution(id, name, description);
    }
}
