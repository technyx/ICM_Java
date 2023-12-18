package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.NewsDto;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.interfaces.NewsService;
import org.technyx.icm.model.service.validation.interfaces.ContentValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ContentRepository repository;

    private final ContentValidation validation;

    private final static String DISCRIMINATOR = "NEWS";

    public NewsServiceImpl(ContentRepository repository, ContentValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }


    @Override
    public NewsDto save(NewsDto dto) {
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content savedNews = repository.save(model);
        dto.getContentFiles().forEach(contentFile ->
                contentFile.setContent(savedNews)
        );
        return mapper.map(savedNews, NewsDto.class);
    }

    @Override
    public NewsDto update(long id, NewsDto dto) {
        dto.setId(id);
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content updatedNews = repository.save(model);
        return mapper.map(updatedNews, NewsDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public NewsDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(
                repository.findById(id), NewsDto.class
        );
    }

    @Override
    public List<NewsDto> showList() {
        List<Content> contents = repository.findAllByDiscriminator(DISCRIMINATOR);
        List<NewsDto> newsDtos = new ArrayList<>();
        contents.forEach(content ->
                newsDtos.add(mapper.map(content, NewsDto.class))
        );
        return newsDtos;
    }
}