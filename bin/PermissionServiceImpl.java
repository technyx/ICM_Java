package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.PermissionDto;
import org.technyx.icm.model.entity.Permission;
import org.technyx.icm.model.repository.PermissionRepository;
import org.technyx.icm.model.service.interfaces.PermissionService;
import org.technyx.icm.model.service.validation.interfaces.PermissionValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final PermissionRepository repository;

    private final PermissionValidation validation;

    public PermissionServiceImpl(PermissionRepository repository, PermissionValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public PermissionDto save(PermissionDto dto) {
        validation.validateSave(dto);
        Permission savedModel = repository.save(
                mapper.map(dto, Permission.class)
        );
        return mapper.map(savedModel, PermissionDto.class);
    }

    @Override
    public PermissionDto update(long id, PermissionDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        Permission updatedModel = repository.save(
                mapper.map(dto, Permission.class)
        );
        return mapper.map(updatedModel, PermissionDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public PermissionDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(repository.findById(id), PermissionDto.class);
    }

    @Override
    public List<PermissionDto> showList() {
        List<Permission> permissionList = repository.findAll();
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissionList.forEach(permission -> permissionDtos
                .add(mapper
                        .map(permission, PermissionDto.class)));
        return permissionDtos;
    }
}
