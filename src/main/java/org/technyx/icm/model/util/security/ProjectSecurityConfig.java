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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests
                        ((requests) -> requests
                                .requestMatchers("/app/v001/**").authenticated()
                                /*.requestMatchers(HttpMethod.POST, "/app/v001/auth/login").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.POST, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.POST, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/app/v001/address").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/address").authenticated()*/
                        )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
