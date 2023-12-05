package org.technyx.icm.model.util.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                                .requestMatchers("/app/v001/auth").authenticated()
                                .requestMatchers(HttpMethod.POST,"/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.PUT,"/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.DELETE,"/app/v001/user").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/user").permitAll()
                                .requestMatchers(HttpMethod.POST,"/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.PUT,"/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.DELETE,"/app/v001/extra-info").authenticated()
                                .requestMatchers(HttpMethod.GET, "/app/v001/extra-info").permitAll()
                        )
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
