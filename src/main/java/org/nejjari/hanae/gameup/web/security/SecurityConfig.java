package org.nejjari.hanae.gameup.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * <p>
 * Defines security filter chains, role-based access control, and password encoding.
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Role constant representing administrative privileges.
     */
    public static final String ADMIN = "ADMIN";

    /**
     * Role constant representing standard user privileges.
     */
    public static final String USER = "USER";

    /**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET).hasRole(USER)
                        .requestMatchers(HttpMethod.GET).hasRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT).hasRole(ADMIN)
                        .requestMatchers(HttpMethod.PATCH).hasRole(ADMIN)
                        .requestMatchers(HttpMethod.DELETE).hasRole(ADMIN)
                        .requestMatchers(HttpMethod.POST).hasRole(ADMIN)
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * Provides a password encoder bean using BCrypt.
     *
     * @return a BCryptPasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}