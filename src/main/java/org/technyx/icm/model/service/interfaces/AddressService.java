package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto save(AddressDto dto);

    AddressDto update(AddressDto dto);

    void delete(AddressDto dto);

    AddressDto showSingle(AddressDto dto);

    List<AddressDto> showList();

    void deleteById(long id);
}
