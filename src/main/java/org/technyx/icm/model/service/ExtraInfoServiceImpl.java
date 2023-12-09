package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.service.interfaces.AddressService;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.validation.interfaces.ExtraInfoValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExtraInfoServiceImpl implements ExtraInfoService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ExtraInfoRepository repository;

    private final ExtraInfoValidation validation;

    private final AddressService addressService;

    public ExtraInfoServiceImpl(ExtraInfoRepository repository, ExtraInfoValidation validation, AddressService addressService) {
        this.repository = repository;
        this.validation = validation;
        this.addressService = addressService;
    }

    @Override
    public ExtraInfoDto save(ExtraInfoDto dto) {
        validation.validateSave(dto);
        ExtraInfo savedModel = repository.save(
                mapper.map(dto, ExtraInfo.class)
        );
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    @Override
    public ExtraInfoDto update(long id,ExtraInfoDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        ExtraInfo updatedModel = repository.save(
                mapper.map(dto, ExtraInfo.class)
        );
        return mapper.map(updatedModel, ExtraInfoDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
        /*todo: implement delete adderess if needed*/
    }

    @Override
    public ExtraInfoDto showSingle(long id) {
        validation.validateExists(id);
        Optional<ExtraInfo> model = repository.findById(id);
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
