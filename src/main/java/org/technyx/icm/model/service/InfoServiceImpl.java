package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.InfoDto;
import org.technyx.icm.model.entity.Info;
import org.technyx.icm.model.repository.InfoRepository;
import org.technyx.icm.model.service.interfaces.InfoService;
import org.technyx.icm.model.service.validation.interfaces.InfoValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InfoServiceImpl implements InfoService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final InfoRepository repository;

    private final InfoValidation validation;

    public InfoServiceImpl(InfoRepository repository, InfoValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public InfoDto save(InfoDto dto) {
        Info model = mapper.map(dto, Info.class);
        validation.validateBaseInfo(model);
        Info savedModel = repository.save(model);
        return mapper.map(savedModel, InfoDto.class);
    }

    @Override
    public InfoDto update(long id, InfoDto dto) {
        dto.setId(id);
        Info model = mapper.map(dto, Info.class);
        validation.validateBaseInfo(model);
        Info savedModel = repository.save(model);
        return mapper.map(savedModel, InfoDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public InfoDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(repository.findById(id), InfoDto.class);
    }

    @Override
    public List<InfoDto> showList(String discriminator) {
        List<Info> infos = repository.findAllByDiscriminator(discriminator);
        List<InfoDto> infoDtos = new ArrayList<>();
        infos.forEach(info ->
                infoDtos.add(mapper.map(info, InfoDto.class)));
        return infoDtos;
    }
}
