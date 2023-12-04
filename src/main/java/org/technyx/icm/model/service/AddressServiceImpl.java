package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.service.interfaces.AddressService;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Override
    public AddressDto save(AddressDto dto) {
        return null;
    }

    @Override
    public AddressDto update(AddressDto dto) {
        return null;
    }

    @Override
    public void delete(AddressDto dto) {

    }

    @Override
    public AddressDto showSingle(AddressDto dto) {
        return null;
    }

    @Override
    public List<AddressDto> showList() {
        return null;
    }
}
