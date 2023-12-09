package org.technyx.icm.model.service;//package org.technyx.icm.model.service;
//
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.technyx.icm.model.dtos.PermissionDto;
//import org.technyx.icm.model.entity.Permission;
//import org.technyx.icm.model.repository.PermissionRepository;
//import org.technyx.icm.model.service.interfaces.PermissionService;
//import org.technyx.icm.model.util.ModelMapperConfig;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class PermissionServiceImpl implements PermissionService {
//
//    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();
//
//    @Autowired
//    private PermissionRepository repository;
//
//    @Override
//    public PermissionDto save(PermissionDto dto) {
//        Permission savedModel = repository.save(
//                mapper.map(dto, Permission.class)
//        );
//        return mapper.map(savedModel, PermissionDto.class);
//    }
//
//    @Override
//    public PermissionDto update(PermissionDto dto) {
//        Permission updatedModel = repository.save(
//                mapper.map(dto, Permission.class)
//        );
//        return mapper.map(updatedModel, PermissionDto.class);
//    }
//
//    @Override
//    public void delete(PermissionDto dto) {
//        repository.delete(mapper.map(dto, Permission.class));
//    }
//
//    @Override
//    public PermissionDto showSingle(PermissionDto dto) {
//        Optional<Permission> permission = repository.findById(dto.getId());
//        return mapper.map(permission, PermissionDto.class);
//    }
//
//    @Override
//    public List<PermissionDto> showList() {
//        List<Permission> permissionList = repository.findAll();
//        List<PermissionDto> permissionDtos = new ArrayList<>();
//        permissionList.forEach(address -> permissionDtos
//                .add(mapper
//                        .map(address, PermissionDto.class)));
//        return permissionDtos;
//    }
//}
