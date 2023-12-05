package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.repository.AddressRepository;
import org.technyx.icm.model.service.interfaces.AddressService;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private AddressRepository repository;

    @Override
    public AddressDto save(AddressDto dto) {
        Address savedModel = repository.save(
                mapper.map(dto, Address.class)
        );
        return mapper.map(savedModel, AddressDto.class);
    }

    @Override
    public AddressDto update(AddressDto dto) {
        Address updatedModel = repository.save(
                mapper.map(dto, Address.class)
        );
        return mapper.map(updatedModel, AddressDto.class);
    }

    @Override
    public void delete(AddressDto dto) {
        repository.delete(mapper.map(dto, Address.class));
    }

    @Override
    public AddressDto showSingle(AddressDto dto) {
        Optional<Address> address = repository.findById(dto.getId());
        return mapper.map(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> showList() {
        List<Address> addressList = repository.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();
        addressList.forEach(address -> addressDtos
                .add(mapper
                        .map(address, AddressDto.class)));
        return addressDtos;
    }
}
