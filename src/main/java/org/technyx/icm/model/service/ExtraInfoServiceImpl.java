package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExtraInfoServiceImpl implements ExtraInfoService {

    @Autowired
    private ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private ExtraInfoRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ExtraInfoDto save(ExtraInfoDto dto) {
        ExtraInfo model = mapper.map(dto, ExtraInfo.class);
        populateSave(model);
        validateSave(model);
        ExtraInfo savedModel = repository.save(model);
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    private void validateSave(ExtraInfo model) {
    }

    private void populateSave(ExtraInfo model) {
    }

    @Override
    public ExtraInfoDto update(ExtraInfoDto dto) {
        ExtraInfo oldModel = repository.findByUser(dto.getUser());
        ExtraInfo newModel = mapper.map(dto, ExtraInfo.class);
        populateUpdate(newModel, oldModel.getId());
        validateUpdate(newModel);
        ExtraInfo savedModel = repository.save(newModel);
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    private void validateUpdate(ExtraInfo newModel) {
    }

    private void populateUpdate(ExtraInfo newModel, int id) {
        newModel.setId(id);
    }

    @Override
    public void delete(ExtraInfoDto dto) {
        ExtraInfo model = mapper.map(dto, ExtraInfo.class);
        repository.deleteByUser(model.getUser());
    }

    @Override
    public ExtraInfoDto showSingle(ExtraInfoDto dto) {
        ExtraInfo model = repository.findByUser(dto.getUser());
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
}
