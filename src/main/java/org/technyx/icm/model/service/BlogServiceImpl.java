package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.BlogDto;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.interfaces.BlogService;
import org.technyx.icm.model.service.validation.interfaces.ContentValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ContentRepository repository;

    private final ContentValidation validation;

    private static final String DISCRIMINATOR = "BLOG";

    public BlogServiceImpl(ContentRepository repository, ContentValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public BlogDto save(BlogDto dto) {
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content savedBlog = repository.save(model);
        return mapper.map(savedBlog, BlogDto.class);
    }

    @Override
    public BlogDto update(long id, BlogDto dto) {
        dto.setId(id);
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content updatedBlog = repository.save(model);
        return mapper.map(updatedBlog, BlogDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public BlogDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(
                repository.findById(id), BlogDto.class
        );
    }

    @Override
    public List<BlogDto> showList() {
        List<Content> contents = repository.findAllByDiscriminator(DISCRIMINATOR);
        List<BlogDto> blogDtos = new ArrayList<>();
        contents.forEach(content ->
                blogDtos.add(mapper.map(content, BlogDto.class))
        );
        return blogDtos;
    }
}
