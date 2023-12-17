package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.PermissionDto;

import java.util.List;

public interface PermissionService {

    PermissionDto save(PermissionDto dto);

    PermissionDto update(long id, PermissionDto dto);

    void delete(long id);

    PermissionDto showSingle(long id);

    List<PermissionDto> showList();
}
