package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.BlogDto;
import org.technyx.icm.model.dtos.NewsDto;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.interfaces.BlogService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ContentRepository repository;

    private static final String DISCRIMINATOR = "BLOG";

    public BlogServiceImpl(ContentRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogDto save(BlogDto dto) {
        dto.setDiscriminator(DISCRIMINATOR);
        Content savedBlog = repository.save(
                mapper.map(dto, Content.class)
        );
        return mapper.map(savedBlog, BlogDto.class);
    }

    @Override
    public BlogDto update(long id, BlogDto dto) {
        dto.setId(id);
        dto.setDiscriminator(DISCRIMINATOR);
        Content updatedBlog = repository.save(
                mapper.map(dto, Content.class)
        );
        return mapper.map(updatedBlog, BlogDto.class);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public BlogDto showSingle(long id) {
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
