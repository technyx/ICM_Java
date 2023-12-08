package org.technyx.icm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.service.interfaces.AuthenticateService;

@SpringBootApplication
@EnableWebSecurity
@EntityScan("org.technyx.icm.model.entity")
@EnableJpaRepositories("org.technyx.icm.model.repository")
public class IcmApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IcmApplication.class, args);
	}

	@Component
	static class OnStartup implements ApplicationRunner {
		@Autowired
		AuthenticateService service;

		@Override
		public void run(ApplicationArguments args) {
			RegisterDto dto = new RegisterDto();
			dto.setUsername("admin");
			dto.setPassword("admin");
			dto.setRole(Role.ADMIN);
			service.register(dto);
		}
	}

}
