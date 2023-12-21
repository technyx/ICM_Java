package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.SeoDto;
import org.technyx.icm.model.entity.Seo;
import org.technyx.icm.model.repository.SeoRepository;
import org.technyx.icm.model.service.interfaces.SeoService;
import org.technyx.icm.model.service.validation.interfaces.SeoValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SeoServiceImpl implements SeoService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final SeoRepository repository;

    private final SeoValidation validation;

    public SeoServiceImpl(SeoRepository repository, SeoValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public SeoDto save(SeoDto dto) {
        Seo model = mapper.map(dto, Seo.class);
        validation.validateBaseInfo(model);
        Seo savedModel = repository.save(model);
        return mapper.map(savedModel, SeoDto.class);
    }

    @Override
    public SeoDto update(long id, SeoDto dto) {
        dto.setId(id);
        Seo model = mapper.map(dto, Seo.class);
        validation.validateBaseInfo(model);
        Seo savedModel = repository.save(model);
        return mapper.map(savedModel, SeoDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public SeoDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(repository.findById(id), SeoDto.class);
    }

    @Override
    public List<SeoDto> showList() {
        List<Seo> seos = repository.findAll();
        List<SeoDto> seoDtos = new ArrayList<>();
        seos.forEach(seo ->
                seoDtos.add(mapper.map(seo, SeoDto.class))
        );
        return seoDtos;
    }
}
