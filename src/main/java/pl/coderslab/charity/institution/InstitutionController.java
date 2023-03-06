package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/institution")
@AllArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/list")
    public List<Institution> getInstitutions() {
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/get/{institutionId}")
    public Institution getInstitutionById(@PathVariable("institutionId") Long id) {
        return institutionService.findById(id);
    }

    @PostMapping
    public void addInstitution(@RequestBody Institution institution) {
        institutionService.saveInstitution(institution);
    }

    @DeleteMapping(path = "{institutionId}")
    public void deleteInstitution(@PathVariable("institutionId") Long id) {
        institutionService.deleteInstitutionById(id);
    }

    @PutMapping(path = "{institutionId}")
    public void updateInstitution(@PathVariable("institutionId") Long id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description) {
        institutionService.updateInstitution(id, name, description);
    }
}
