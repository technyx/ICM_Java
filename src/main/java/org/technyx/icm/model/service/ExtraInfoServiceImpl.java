package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExtraInfoServiceImpl implements ExtraInfoService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private ExtraInfoRepository repository;

    @Override
    public ExtraInfoDto save(ExtraInfoDto dto) {
        ExtraInfo savedModel = repository.save(
                mapper.map(dto, ExtraInfo.class)
        );
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    @Override
    public ExtraInfoDto update(ExtraInfoDto dto) {
        ExtraInfo updatedModel = repository.save(
                mapper.map(dto, ExtraInfo.class)
        );
        return mapper.map(updatedModel, ExtraInfoDto.class);
    }

    @Override
    public void delete(ExtraInfoDto dto) {
        repository.delete(mapper.map(dto, ExtraInfo.class));
    }

    @Override
    public ExtraInfoDto showSingle(ExtraInfoDto dto) {
        Optional<ExtraInfo> model = repository.findById(dto.getId());
        return mapper.map(model, ExtraInfoDto.class);
    }

    @Override
    public List<ExtraInfoDto> showList() {
        List<ExtraInfoDto> extraInfoDtos = new ArrayList<>();
        List<ExtraInfo> modelList = repository.findAll();
        modelList.forEach(extraInfo -> extraInfoDtos
                .add(mapper.map(extraInfo, ExtraInfoDto.class)));
        return extraInfoDtos;
    }

    @Override
    public boolean existsById(long id) {
        return repository.existsById(id);
    }
}
