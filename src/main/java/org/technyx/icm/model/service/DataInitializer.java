package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        createBaseUsers();
    }

    private void createBaseUsers() {
        RegisterDto _1_admin = new RegisterDto();
        _1_admin.setUsername("4490434772");
        _1_admin.setPassword("admin111");
        _1_admin.setNationalCode("4490434772");
        _1_admin.setRole(Role.ADMIN);
        authenticateService.register(_1_admin);

        RegisterDto _1_user = new RegisterDto();
        _1_user.setUsername("4490434773");
        _1_user.setPassword("employee1");
        _1_user.setNationalCode("4490434773");
        _1_user.setRole(Role.EMPLOYEE);
        authenticateService.register(_1_user);

        RegisterDto _2_user = new RegisterDto();
        _2_user.setUsername("4490434774");
        _2_user.setPassword("employee2");
        _2_user.setNationalCode("4490434774");
        _2_user.setRole(Role.EMPLOYEE);
        authenticateService.register(_2_user);
    }
}
