package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.repository.AddressRepository;
import org.technyx.icm.model.service.interfaces.AddressService;
import org.technyx.icm.model.service.validation.interfaces.AddressValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final AddressRepository repository;

    private final AddressValidation validation;

    public AddressServiceImpl(AddressRepository repository, AddressValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public AddressDto save(AddressDto dto) {
        validation.validateSave(dto);
        Address savedModel = repository.save(
                mapper.map(dto, Address.class)
        );
        return mapper.map(savedModel, AddressDto.class);
    }

    @Override
    public AddressDto update(long id, AddressDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        Address updatedModel = repository.save(
                mapper.map(dto, Address.class)
        );
        return mapper.map(updatedModel, AddressDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public AddressDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(repository.findById(id), AddressDto.class);
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
