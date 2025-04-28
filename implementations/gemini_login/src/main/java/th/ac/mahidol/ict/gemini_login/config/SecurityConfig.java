package th.ac.mahidol.ict.gemini_login.config;

import th.ac.mahidol.ict.gemini_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        // Admin pages: only admin users can access the "View All Users" and "Create New User" pages
                        .requestMatchers("/users", "/register", "/register/**").hasRole("ADMINISTRATOR")

                        .requestMatchers("/observing-program-form").authenticated()

                        // Authenticated users can access the configuration pages
                        .requestMatchers("/view-configurations", "/view-default-config", "/update-config").authenticated()

                        .requestMatchers("/create-science-plan-form","/create-science-plan").hasRole("ASTRONOMER")
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
