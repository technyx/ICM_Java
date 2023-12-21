package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.PartnerDto;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.interfaces.PartnerService;
import org.technyx.icm.model.service.validation.interfaces.ContentValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ContentRepository repository;

    private final ContentValidation validation;

    private final static String DISCRIMINATOR = "PARTNER";

    public PartnerServiceImpl(ContentRepository repository, ContentValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public PartnerDto save(PartnerDto dto) {
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content savedPartner = repository.save(model);
        dto.getContentFiles().forEach(contentFile ->
                contentFile.setContent(savedPartner)
        );
        return mapper.map(savedPartner, PartnerDto.class);
    }

    @Override
    public PartnerDto update(long id, PartnerDto dto) {
        dto.setId(id);
        dto.setDiscriminator(DISCRIMINATOR);
        Content model = mapper.map(dto, Content.class);
        validation.validateBaseInfo(model);
        Content updatedPartner = repository.save(model);
        return mapper.map(updatedPartner, PartnerDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public PartnerDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(
                repository.findById(id), PartnerDto.class
        );
    }

    @Override
    public List<PartnerDto> showList() {
        List<Content> contents = repository.findAllByDiscriminator(DISCRIMINATOR);
        List<PartnerDto> partnerDtos = new ArrayList<>();
        contents.forEach(content ->
                partnerDtos.add(mapper.map(content, PartnerDto.class))
        );
        return partnerDtos;
    }

}
