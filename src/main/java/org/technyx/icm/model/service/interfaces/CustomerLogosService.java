package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.CustomerLogosDto;

import java.util.List;

public interface CustomerLogosService {
    CustomerLogosDto save(CustomerLogosDto dto);

    CustomerLogosDto update(long id, CustomerLogosDto dto);

    void delete(long id);

    CustomerLogosDto showSingle(long id);

    List<CustomerLogosDto> showList();
}
