package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.dtos.UserWithExtraInfoDto;
import org.technyx.icm.model.dtos.UserWithFullDataDto;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.service.interfaces.DataTypeService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.sql.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private UserService userService;

    @Autowired
    private DataTypeService dataTypeService;

    @Override
    public void run(String... args) throws Exception {
        createDatTypes();
        createBaseUsers();
        createExtraInfoUser();
        createFullUser();
    }

    private void createDatTypes() {
        DataType _1_dataType = new DataType();
        _1_dataType.setDiscriminator("CITY_NAME");
        _1_dataType.setEngTitle("Ilam");
        _1_dataType.setPerTitle("ایلام");
        _1_dataType.setPriority(1);
        dataTypeService.save(_1_dataType);

        DataType _2_dataType = new DataType();
        _2_dataType.setDiscriminator("CITY_NAME");
        _2_dataType.setEngTitle("Tehran");
        _2_dataType.setPerTitle("تهران");
        _2_dataType.setPriority(2);
        dataTypeService.save(_2_dataType);

        DataType _3_dataType = new DataType();
        _3_dataType.setDiscriminator("CITY_NAME");
        _3_dataType.setEngTitle("Esfehan");
        _3_dataType.setPerTitle("اصفهان");
        _3_dataType.setPriority(3);
        dataTypeService.save(_3_dataType);
    }

    private void createBaseUsers() {
        RegisterDto _1_admin = new RegisterDto();
        _1_admin.setUsername("4490434772");
        _1_admin.setPassword("admin111");
        _1_admin.setNationalCode("4490434772");
        _1_admin.setRole(Role.ADMIN);
        authenticateService.register(_1_admin);

        RegisterDto _1_employee = new RegisterDto();
        _1_employee.setUsername("4490434773");
        _1_employee.setPassword("employee1");
        _1_employee.setNationalCode("4490434773");
        _1_employee.setRole(Role.EMPLOYEE);
        authenticateService.register(_1_employee);

        RegisterDto _2_employee = new RegisterDto();
        _2_employee.setUsername("4490434774");
        _2_employee.setPassword("employee2");
        _2_employee.setNationalCode("4490434774");
        _2_employee.setRole(Role.EMPLOYEE);
        authenticateService.register(_2_employee);
    }

    private void createExtraInfoUser() {
        UserWithExtraInfoDto _1_admin = new UserWithExtraInfoDto();
        _1_admin.setUsername("4490434775");
        _1_admin.setPassword("admin111");
        _1_admin.setNationalCode("4490434775");
        _1_admin.setRole(Role.ADMIN);
        _1_admin.setFirstname("علی");
        _1_admin.setLastname("میرزاد");
        _1_admin.setBirthDate(Date.valueOf("1998-01-01"));
        _1_admin.setPhone("+989918114840");
        userService.saveWithExtraInfo(_1_admin);

        UserWithExtraInfoDto _1_employee = new UserWithExtraInfoDto();
        _1_employee.setUsername("4490434776");
        _1_employee.setPassword("employee1");
        _1_employee.setNationalCode("4490434776");
        _1_employee.setRole(Role.EMPLOYEE);
        _1_employee.setFirstname("مهناز");
        _1_employee.setLastname("حسینی");
        _1_employee.setBirthDate(Date.valueOf("1998-01-02"));
        _1_employee.setPhone("+989918114841");
        userService.saveWithExtraInfo(_1_employee);

        UserWithExtraInfoDto _2_employee = new UserWithExtraInfoDto();
        _2_employee.setUsername("4490434777");
        _2_employee.setPassword("employee2");
        _2_employee.setNationalCode("4490434777");
        _2_employee.setRole(Role.EMPLOYEE);
        _2_employee.setFirstname("سنا");
        _2_employee.setLastname("علیمردانی");
        _2_employee.setBirthDate(Date.valueOf("1998-01-03"));
        _2_employee.setPhone("+989918114842");
        userService.saveWithExtraInfo(_2_employee);
    }

    private void createFullUser() {
        UserWithFullDataDto _1_admin = new UserWithFullDataDto();
        _1_admin.setUsername("4490434778");
        _1_admin.setPassword("admin111");
        _1_admin.setNationalCode("4490434778");
        _1_admin.setRole(Role.ADMIN);
        _1_admin.setFirstname("محمد");
        _1_admin.setLastname("میرزاد");
        _1_admin.setBirthDate(Date.valueOf("1998-01-04"));
        _1_admin.setPhone("+989918114840");
        _1_admin.setCity("ایلام");
        _1_admin.setLocation("ایلام ایلام 2");
        _1_admin.setPostalCode("1234567891");
        userService.saveWithFullData(_1_admin);

        UserWithFullDataDto _1_employee = new UserWithFullDataDto();
        _1_employee.setUsername("4490434779");
        _1_employee.setPassword("employee1");
        _1_employee.setNationalCode("4490434779");
        _1_employee.setRole(Role.EMPLOYEE);
        _1_employee.setFirstname("رضا");
        _1_employee.setLastname("حسینی");
        _1_employee.setBirthDate(Date.valueOf("1998-01-05"));
        _1_employee.setPhone("+989918114841");
        _1_employee.setCity("اصفهان");
        _1_employee.setLocation("ایلام مشهد 2");
        _1_employee.setPostalCode("1234567892");
        userService.saveWithFullData(_1_employee);

        UserWithFullDataDto _2_employee = new UserWithFullDataDto();
        _2_employee.setUsername("4490434780");
        _2_employee.setPassword("employee2");
        _2_employee.setNationalCode("4490434780");
        _2_employee.setRole(Role.EMPLOYEE);
        _2_employee.setFirstname("صبا");
        _2_employee.setLastname("علیمردانی");
        _2_employee.setBirthDate(Date.valueOf("1998-01-06"));
        _2_employee.setPhone("+989918114842");
        _2_employee.setCity("تهران");
        _2_employee.setLocation("ایلام تهران 2");
        _2_employee.setPostalCode("1234567893");
        userService.saveWithFullData(_2_employee);
    }
}
