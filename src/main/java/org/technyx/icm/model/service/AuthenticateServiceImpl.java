package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
public class AuthenticateServiceImpl implements AuthenticateService {

    @Autowired
    private ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private UserRepository repository;

    @Override
    public RegisterDto register(RegisterDto dto) {
        User model = mapper.map(dto, User.class);
        model.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        model.setPassword(ProjectSecurityConfig.passwordEncoder().encode(model.getPassword()));
        User savedModel = repository.save(model);
        RegisterDto savedDto = mapper.map(savedModel, RegisterDto.class);
        savedDto.setPassword("private");
        return savedDto;
    }
}
