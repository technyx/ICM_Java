package org.technyx.icm.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.*;
import org.technyx.icm.model.entity.*;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.service.interfaces.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private DataTypeService dataTypeService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private FaqService faqService;

    private final static String CITY = "CITY_NAME";

    private final static String NEWS = "NEWS";

    private final static String BLOG = "BLOG";

    private final static String ABOUT = "ABOUT";

    private final static String CONTACT = "CONTACT";


    @Override
    public void run(String... args) throws Exception {
        createBaseUsers();
    }

    private void createBaseUsers() {
        Address _1_address = new Address();
        _1_address.setCity("ایلام");
        _1_address.setLocation("دفتر تیم تولید");
        _1_address.setPostalCode("1112221110");
        ExtraInfo _1_extraInfo = new ExtraInfo();
        _1_extraInfo.setFirstname("تیم تولید");
        _1_extraInfo.setLastname("تیم تولید");
        _1_extraInfo.setPhone("+980000000000");
        _1_extraInfo.setBirthDate(Date.valueOf("1000-01-01"));
        _1_extraInfo.setAddress(_1_address);
        UserDto _1_admin = new UserDto();
        _1_admin.setUsername("develop1");
        _1_admin.setPassword("develop1");
        _1_admin.setNationalCode("0000000000");
        _1_admin.setRole(Role.ADMIN);
        _1_admin.setExtraInfo(_1_extraInfo);
        authenticateService.register(_1_admin);
    }
}
