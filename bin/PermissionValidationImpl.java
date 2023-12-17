package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.PermissionDto;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.repository.PermissionRepository;
import org.technyx.icm.model.service.validation.interfaces.PermissionValidation;
import org.technyx.icm.model.util.exception.PermissionExceptionMessage;
import org.technyx.icm.model.util.exception.base.PermissionException;

@Component
public class PermissionValidationImpl implements PermissionValidation {

    private final PermissionRepository repository;

    private final DataTypeRepository dataTypeRepository;

    public PermissionValidationImpl(PermissionRepository repository, DataTypeRepository dataTypeRepository) {
        this.repository = repository;
        this.dataTypeRepository = dataTypeRepository;
    }

    private void validateBaseInfo(PermissionDto dto) {
//        List<DataType> permissionTypes = dataTypeRepository.findByDiscriminatorOrderByPriority(Discriminator);
//        if (permissionTypes.stream().noneMatch(dataType -> dataType.getPerTitle().equals(dto.getTitle())))
//            throw new PermissionException(PermissionExceptionMessage.TITLE_NOT_FOUND.getExceptionMessage());
    }

    @Override
    public void validateSave(PermissionDto dto) {
        validateBaseInfo(dto);

    }

    @Override
    public void validateUpdate(PermissionDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new PermissionException(PermissionExceptionMessage.TITLE_NOT_FOUND.getExceptionMessage());
    }
}
