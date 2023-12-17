package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.PermissionDto;

public interface PermissionValidation {

    void validateSave(PermissionDto dto);

    void validateUpdate(PermissionDto dto);

    void validateExists(long id);
}
