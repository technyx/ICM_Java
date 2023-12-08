package org.technyx.icm.model.util.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests
                        ((requests) -> requests
                                .requestMatchers(HttpMethod.POST, "/app/v001/auth/register").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/app/v001/user/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/user").permitAll()
                                .requestMatchers(HttpMethod.POST, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/extra-info").permitAll()
                                .requestMatchers(HttpMethod.POST, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/address").permitAll()
                        )
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
