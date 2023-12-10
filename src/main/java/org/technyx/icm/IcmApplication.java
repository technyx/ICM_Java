package org.technyx.icm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EntityScan("org.technyx.icm.model.entity")
@EnableJpaRepositories("org.technyx.icm.model.repository")
public class IcmApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IcmApplication.class, args);
    }
}
