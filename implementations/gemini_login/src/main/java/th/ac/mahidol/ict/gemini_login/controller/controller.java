package th.ac.mahidol.ict.gemini_login.controller;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import th.ac.mahidol.ict.gemini_login.entity.User;
import th.ac.mahidol.ict.gemini_login.repository.UserRepository;
import th.ac.mahidol.ict.gemini_login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
public class controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("message", "User created successfully!");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/welcome";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        // Prevent deletion of Admin (ID 1)
        if (id == 1) {
            redirectAttributes.addFlashAttribute("error", "Cannot delete the Admin user.");
            return "redirect:/users";
        }

        if (!userRepository.existsById(id)) {
            redirectAttributes.addFlashAttribute("error", "User ID " + id + " not found.");
            return "redirect:/users";
        }

        userRepository.deleteById(id);

        List<User> usersToShift = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getId() > id)
                .sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList());

        for (User user : usersToShift) {
            int newId = user.getId() - 1;
            userRepository.deleteById(user.getId());
            user.setId(newId);
            userRepository.save(user);
        }

        redirectAttributes.addFlashAttribute("message", "User deleted and IDs updated.");
        return "redirect:/users";
    }

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal UserDetails userDetails,
                          Model model,
                          @ModelAttribute("message") String message,
                          @ModelAttribute("error") String error) {
        if (userDetails == null) {
            return "redirect:/login?error=unauthorized";
        }

        model.addAttribute("username", userDetails.getUsername());

        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(auth -> auth.getAuthority())
                .orElse("ROLE_UNKNOWN");

        // Redirect Science Observer to observing program form
        if (role.equals("ROLE_SCIENCE_OBSERVER")) {
            return "redirect:/observing-program-form";
        }

        model.addAttribute("role", role);
        model.addAttribute("message", message);
        model.addAttribute("error", error);

        return "welcome";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model,
                              @ModelAttribute("message") String message,
                              @ModelAttribute("error") String error) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("message", message);
        model.addAttribute("error", error);
        return "user-list";
    }
}
