package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.ExtraInfoException;
import org.technyx.icm.model.util.exception.base.UserException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExtraInfoServiceImpl implements ExtraInfoService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private ExtraInfoRepository repository;

    @Autowired
    private UserService userService;


    @Override
    public ExtraInfoDto save(ExtraInfoDto dto) {
        ExtraInfo model = mapper.map(dto, ExtraInfo.class);
        if (!userService.existsById(model.getUser())) {
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getErrorMessage());
        }
        ExtraInfo savedModel = repository.save(model);
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    @Override
    public ExtraInfoDto update(ExtraInfoDto dto) {
        Long oldModelId = repository.findIdByUserId(dto.getUser());
        ExtraInfo newModel = mapper.map(dto, ExtraInfo.class);
        newModel.setId(oldModelId);
        ExtraInfo savedModel = repository.save(newModel);
        return mapper.map(savedModel, ExtraInfoDto.class);
    }

    @Override
    public void delete(ExtraInfoDto dto) {
        repository.deleteByUser(dto.getUser());
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
