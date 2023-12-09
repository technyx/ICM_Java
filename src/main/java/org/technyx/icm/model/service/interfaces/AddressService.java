package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto save(AddressDto dto);

    AddressDto update(long id, AddressDto dto);

    void delete(long id);

    AddressDto showSingle(long id);

    List<AddressDto> showList();
}
