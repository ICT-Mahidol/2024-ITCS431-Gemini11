package th.ac.mahidol.ict.gemini_login.config;

import th.ac.mahidol.ict.gemini_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Secure the configuration pages, require authentication
                        .requestMatchers("/view-configurations", "/view-default-config", "/update-config").authenticated()

                        // Allow the registration page for users with the ADMINISTRATOR role
                        .requestMatchers("/register", "/register/**").hasRole("ADMINISTRATOR")

                        // Allow all other requests (public access to pages like the Welcome page)
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Define login page URL
                        .defaultSuccessUrl("/welcome", true)  // Redirect after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                        .permitAll()
                )
                .userDetailsService(userService)  // Use custom UserService for authentication
                .csrf().disable();  // Disable CSRF for simplicity (can be enabled in production if needed)

        return http.build();
    }
}
