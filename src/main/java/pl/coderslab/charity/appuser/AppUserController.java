package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleService;
import pl.coderslab.charity.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;
import java.util.Set;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final PasswordEncoder passwordEncoder;

    private final AppUserService appUserService;

    private final RoleService roleService;

    @GetMapping("register")
    public String registerUser(Model model, HttpSession session) {
        if (session.getAttribute("userDTO") != null) {
            return "registration";
        }

        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        session.setAttribute("userDTO", userDTO);

        return "registration";
    }

    @PostMapping("register")
    public String saveUser(@Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           Model model,
                           HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    "err",
                    "BINDING RESULT WRONG");
            return "redirect:register";
        }

        if (appUserService.findByEmail(userDTO.getUsername()).isPresent()) {
            userDTO.setError(
                    "Istnieje już konto powiązane z tym adresem email"
            );
            session.setAttribute("userDTO", userDTO);
            return "redirect:/register";
        }

        if (!Objects.equals(userDTO.getPassword(), userDTO.getPassword2())) {
            userDTO.setError(
                    "Podane hasła różnią się od siebie"
            );
            session.setAttribute("userDTO", userDTO);
            return "redirect:/register";
        }

        session.removeAttribute("userDTO");

        AppUser appUser = new AppUser();
        appUser.setFirstName(userDTO.getFirstName());
        appUser.setLastName(userDTO.getLastName());
        appUser.setEmail(userDTO.getUsername());
        appUser.setPassword(
                passwordEncoder.encode(userDTO.getPassword())
        );

        Set<Role> roles = roleService.findRolesByName("ROLE_USER");
        appUser.setRoles(roles);

        appUser.setEnabled(true);

        appUserService.saveUser(appUser);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
