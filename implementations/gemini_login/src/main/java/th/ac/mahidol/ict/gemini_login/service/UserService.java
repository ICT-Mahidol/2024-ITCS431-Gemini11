package th.ac.mahidol.ict.gemini_login.service;

import th.ac.mahidol.ict.gemini_login.entity.User;
import th.ac.mahidol.ict.gemini_login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("Admin").isEmpty()) {
            User admin = new User();

            // Auto-assign ID manually (find next available ID)
            int id = 1;
            while (userRepository.existsById(id)) {
                id++;
            }
            admin.setId(id);

            admin.setUsername("Admin");
            admin.setPassword(passwordEncoder.encode("Admin"));
            admin.setRole("ROLE_ADMINISTRATOR");

            userRepository.save(admin);
        }
    }

    public void registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // Find next available ID
        int id = 1;
        while (userRepository.existsById(id)) {
            id++;
        }
        user.setId(id);

        String formattedRole = "ROLE_" + user.getRole().trim().toUpperCase().replace(" ", "_");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(formattedRole);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
