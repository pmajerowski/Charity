package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }

    public void saveInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    public void deleteInstitutionById(Long id) {
        boolean exists = institutionRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Institution with given id does not exist");
        }
        institutionRepository.deleteById(id);
    }

    @Transactional
    public void updateInstitution(Long institutionId, String name, String description) {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new IllegalStateException("Institution with given id does not exist"));

        if (name != null && name.length() > 0) {
            institution.setName(name);
        }

        if (description != null && description.length() > 0) {
            institution.setDescription(description);
        }

    }

}
