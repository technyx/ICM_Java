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
        createDataTypes();
        createBaseUsers();
//        createBaseBlog();
//        createBaseNews();
//        createBaseAbout();
//        createBaseContact();
//        createBaseFaq();
    }

    private void createBaseAbout() {
        InfoDto infoDto = new InfoDto();
        infoDto.setTitle("درباره ما");
        infoDto.setText("در باره شرکت ما، یه عده کسخولیم کیرم دهن هرکی میخونه اینو");
        File _1_file = new File();
        _1_file.setDiscriminator(ABOUT);
        _1_file.setUrl("urlAbout9");
        File _2_file = new File();
        _2_file.setDiscriminator(ABOUT);
        _2_file.setUrl("urlAbout10");
        infoDto.setFiles(Arrays.asList(_1_file, _2_file));
        infoDto.setDiscriminator(ABOUT);
        infoService.save(infoDto);
    }

    private void createBaseContact() {
        for (int i = 0; i < 3; i++) {
            InfoDto infoDto = new InfoDto();
            infoDto.setTitle("شماره عمت");
            infoDto.setText("متن عشقی 129857");
            File _1_file = new File();
            _1_file.setDiscriminator(CONTACT);
            _1_file.setUrl("urlContact999" + i);
            File _2_file = new File();
            _2_file.setDiscriminator(CONTACT);
            _2_file.setUrl("urlContact999" + i);
            infoDto.setDiscriminator(CONTACT);
            infoDto.setFiles(Arrays.asList(_1_file));
            infoService.save(infoDto);
        }
    }

    private void createBaseFaq() {
        int minCodePoint = 0x0600;
        int maxCodePoint = 0x06FF;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomCodePoint = random.nextInt(maxCodePoint - minCodePoint + 1) + minCodePoint;
            char randomPersianChar = (char) randomCodePoint;
            FaqDto faqDto = new FaqDto();
            faqDto.setQuestion("سوال کیری" + randomPersianChar);
            faqDto.setAnswer("جواب تخمی" + randomPersianChar);
            faqService.save(faqDto);
        }
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
        int minCodePoint = 0x0600;
        int maxCodePoint = 0x06FF;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomCodePoint = random.nextInt(maxCodePoint - minCodePoint + 1) + minCodePoint;
            char randomPersianChar = (char) randomCodePoint;
            ExtraInfo extrainfo = new ExtraInfo();
            extrainfo.setFirstname("نام " +  randomPersianChar);
            extrainfo.setLastname("فامیلی " + randomPersianChar);
            extrainfo.setPhone("+98991811484" + i);
            extrainfo.setBirthDate(Date.valueOf("1998-01-02"));
            UserDto emp = new UserDto();
            emp.setUsername("449043471" + i);
            emp.setPassword("e449043471" + i);
            emp.setNationalCode("449043471" + i);
            emp.setRole(Role.EMPLOYEE);
            emp.setExtraInfo(extrainfo);
            authenticateService.register(emp);
        }
    }

    private void createBaseNews() {
        for (int i = 0; i < 10; i++) {
            NewsDto news = new NewsDto();
            news.setTitle("خیر کیری" + i);
            news.setDescription("این خبر کیری برای کون همه pms هاست" + i);
            news.setImportant(true);
            news.setMetaKeyword("kir, kos, kon" + i);
            news.setMetaDescription("hamatoon anid" + i);
            List<ContentFile> contentFile = Arrays.asList(
                    new ContentFile("urlNews1" + i, 0, null),
                    new ContentFile("urlNews2" + i, 1, null),
                    new ContentFile("urlNews3" + i, 2, null)
            );
            news.setContentFiles(contentFile);
            newsService.save(news);
        }
    }

    private void createBaseBlog() {
        for (int i = 0; i < 10; i++) {
            BlogDto blog = new BlogDto();
            blog.setTitle("مقاله کیری" + i);
            blog.setDescription("این مقاله کیری برای کون همه pms هاست" + i);
            blog.setImportant(true);
            blog.setMetaKeyword("mame, kos, kon" + i);
            blog.setMetaDescription("hamatoon eshalid" + i);
            List<ContentFile> contentFile = Arrays.asList(
                    new ContentFile("urlBlog1" + i, 0, null),
                    new ContentFile("urlBlog2" + i, 1, null),
                    new ContentFile("urlBlog3" + i, 2, null)
            );
            blog.setContentFiles(contentFile);
            blogService.save(blog);
        }
    }
}
