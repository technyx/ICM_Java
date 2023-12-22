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
                                .requestMatchers("/auth/register").authenticated()
                                .requestMatchers("/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/user/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/user/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/user/**").authenticated()
                                .requestMatchers(HttpMethod.POST, "/file/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/file/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/file/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/file/**").permitAll()
                                .requestMatchers("/payslip/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/payslip/user/**").authenticated()
                                .requestMatchers(HttpMethod.POST, "/logo/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/logo/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/logo/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/logo/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/faq/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/faq/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/faq/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/faq/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/news/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/news/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/news/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/news/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/blog/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/blog/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/blog/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/blog/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/partner/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/partner/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/partner/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/partner/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/course/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/course/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/course/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/course/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/info/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/info/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/info/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/info/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/util/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/gallery/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/gallery/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/gallery/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/gallery/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/service/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/service/**").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/service/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/service/**").permitAll()
                        )
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
