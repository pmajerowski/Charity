package pl.coderslab.charity.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Set<Role> findRolesByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public Set<Role> findAllRoles() {
        return roleRepository.getAllBy();
    }
}
