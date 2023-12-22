package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.ServiceDto;

import java.util.List;

public interface ServiceService {

    ServiceDto save(ServiceDto dto);

    ServiceDto update(long id, ServiceDto dto);

    void delete(long id);

    ServiceDto showSingle(long id);

    List<ServiceDto> showList();
}
