package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    @Lazy
    private ExtraInfoService extraInfoService;

    private void validateSave(User model) {
    }

    private void populateSave(User model) {
        model.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        model.setPassword(ProjectSecurityConfig.passwordEncoder().encode(model.getPassword()));
    }

    @Override
    public boolean existsById(long id) {
        return repository.existsUserById(id);
    }

    @Override
    public FullUserDto fullSave(FullUserDto dto) {
        populateFullSave(dto);
        validateFullSave(dto);
        User savedUser = repository.save(mapper.map(dto, User.class));
        ExtraInfoDto savedExtraInfo = extraInfoService.save(mapper.map(dto, ExtraInfoDto.class));
        FullUserDto newFullUserDto = new FullUserDto();
        newFullUserDto.map2Model(savedUser, mapper.map(savedExtraInfo, ExtraInfo.class));
        return newFullUserDto;
    }

    private void validateFullSave(FullUserDto dto) {
    }

    private void populateFullSave(FullUserDto dto) {
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
    }
}
