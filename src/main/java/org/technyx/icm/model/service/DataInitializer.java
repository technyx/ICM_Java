package org.technyx.icm.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.InfoDto;
import org.technyx.icm.model.dtos.NewsDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.entity.*;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.service.interfaces.InfoService;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.service.interfaces.DataTypeService;
import org.technyx.icm.model.service.interfaces.NewsService;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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

    private final static String CITY = "CITY_NAME";

    private final static String NEWS = "NEWS";

    private final static String ABOUT = "ABOUT";

    private final static String CONTACT = "CONTACT";

    @Override
    public void run(String... args) throws Exception {
        createDataTypes();
        createBaseUsers();
        createBaseContact();
        createBaseAbout();
    }

    private void createBaseAbout() {
        InfoDto infoDto = new InfoDto();
        infoDto.setTitle("درباره ما");
        infoDto.setText("در باره شرکت ما، یه عده کسخولیم کیرم دهن هرکی میخونه اینو");
        File _1_file = new File();
        _1_file.setDiscriminator(ABOUT);
        _1_file.setUrl("url9");
        File _2_file = new File();
        _2_file.setDiscriminator(ABOUT);
        _2_file.setUrl("url10");
        infoDto.setFiles(Arrays.asList(_1_file, _2_file));
        infoDto.setDiscriminator(ABOUT);
        infoService.save(infoDto);
    }

    private void createBaseContact() {
        InfoDto infoDto = new InfoDto();
        infoDto.setTitle("درباره ما");
        infoDto.setText("در باره شرکت ما، یه عده کسخولیم کیرم دهن هرکی میخونه اینو");
        File _1_file = new File();
        _1_file.setDiscriminator(CONTACT);
        _1_file.setUrl("url123");
        File _2_file = new File();
        _2_file.setDiscriminator(CONTACT);
        _2_file.setUrl("url1234");
        infoDto.setDiscriminator(CONTACT);
        infoDto.setFiles(Arrays.asList(_1_file, _2_file));
        infoService.save(infoDto);
    }

    private void createDataTypes() {
        DataType _1_dataType = new DataType();
        _1_dataType.setDiscriminator(CITY);
        _1_dataType.setEngTitle("Ilam");
        _1_dataType.setPerTitle("ایلام");
        _1_dataType.setPriority(1);
        dataTypeService.save(_1_dataType);

        DataType _2_dataType = new DataType();
        _2_dataType.setDiscriminator(CITY);
        _2_dataType.setEngTitle("Tehran");
        _2_dataType.setPerTitle("تهران");
        _2_dataType.setPriority(2);
        dataTypeService.save(_2_dataType);

        DataType _3_dataType = new DataType();
        _3_dataType.setDiscriminator(CITY);
        _3_dataType.setEngTitle("Esfehan");
        _3_dataType.setPerTitle("اصفهان");
        _3_dataType.setPriority(3);
        dataTypeService.save(_3_dataType);
    }

    private void createBaseUsers() {
        Address _1_address = new Address();
        _1_address.setCity("ایلام");
        _1_address.setLocation("خ صاحب الزمان پلاک 1");
        _1_address.setPostalCode("1112221110");
        ExtraInfo _1_extraInfo = new ExtraInfo();
        _1_extraInfo.setFirstname("علی");
        _1_extraInfo.setLastname("میرزاد");
        _1_extraInfo.setPhone("+989918114840");
        _1_extraInfo.setBirthDate(Date.valueOf("1998-01-01"));
        _1_extraInfo.setAddress(_1_address);
        UserDto _1_admin = new UserDto();
        _1_admin.setUsername("4490434774");
        _1_admin.setPassword("a4490434774");
        _1_admin.setNationalCode("4490434772");
        _1_admin.setRole(Role.ADMIN);
        _1_admin.setExtraInfo(_1_extraInfo);
        authenticateService.register(_1_admin);

        ExtraInfo _2_extraInfo = new ExtraInfo();
        _2_extraInfo.setFirstname("حجت");
        _2_extraInfo.setLastname("حسینی");
        _2_extraInfo.setPhone("+989918114841");
        _2_extraInfo.setBirthDate(Date.valueOf("1998-01-02"));
        UserDto _2_employee = new UserDto();
        _2_employee.setUsername("4490434775");
        _2_employee.setPassword("e4490434775");
        _2_employee.setNationalCode("4490434775");
        _2_employee.setRole(Role.EMPLOYEE);
        _2_employee.setExtraInfo(_2_extraInfo);
        authenticateService.register(_2_employee);
    }

    private void createBaseNews() {
        NewsDto _1_news = new NewsDto();
        _1_news.setDiscriminator(NEWS);
        _1_news.setTitle("خبر کیری");
        _1_news.setDescription("این خبر کیری برای کون همه pms هاست");
        _1_news.setImportant(true);
        _1_news.setMetaKeyword("kir, kos, kon");
        _1_news.setMetaDescription("hamatoon anid");
        List<ContentFile> contentFile = Arrays.asList(
                new ContentFile("url1", 0, null),
                new ContentFile("url2", 1, null),
                new ContentFile("url3", 2, null)
        );
        _1_news.setContentFiles(contentFile);
        newsService.save(_1_news);
    }
}
