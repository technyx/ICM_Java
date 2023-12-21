package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.CourseDto;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.interfaces.CourseService;
import org.technyx.icm.model.service.validation.interfaces.ContentValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ContentRepository repository;

    private final ContentValidation validation;

    private final static String DISCRIMINATOR = "COURSE";

    public CourseServiceImpl(ContentRepository repository, ContentValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public CourseDto save(CourseDto dto) {
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content savedCourse = repository.save(model);
        dto.getContentFiles().forEach(contentFile ->
                contentFile.setContent(savedCourse)
        );
        return mapper.map(savedCourse, CourseDto.class);
    }

    @Override
    public CourseDto update(long id, CourseDto dto) {
        dto.setId(id);
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content updatedCourse = repository.save(model);
        return mapper.map(updatedCourse, CourseDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public CourseDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(
                repository.findById(id), CourseDto.class
        );
    }

    @Override
    public List<CourseDto> showList() {
        List<Content> contents = repository.findAllByDiscriminator(DISCRIMINATOR);
        List<CourseDto> courseDtos = new ArrayList<>();
        contents.forEach(content ->
                courseDtos.add(mapper.map(content, CourseDto.class))
        );
        return courseDtos;
    }
}