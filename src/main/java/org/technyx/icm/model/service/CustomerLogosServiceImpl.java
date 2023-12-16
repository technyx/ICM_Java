package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.CustomerLogosDto;
import org.technyx.icm.model.entity.CustomerLogos;
import org.technyx.icm.model.repository.CustomerLogosRepository;
import org.technyx.icm.model.service.interfaces.CustomerLogosService;
import org.technyx.icm.model.service.validation.interfaces.CustomerLogosValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerLogosServiceImpl implements CustomerLogosService {
    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();


    private final CustomerLogosRepository repository;

    private final CustomerLogosValidation validation;

    public CustomerLogosServiceImpl(CustomerLogosRepository repository, CustomerLogosValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public CustomerLogosDto save(CustomerLogosDto dto) {
        validation.validateSave(dto);
        CustomerLogos savedModel = repository.save(
                mapper.map(dto, CustomerLogos.class)
        );
        return mapper.map(savedModel, CustomerLogosDto.class);
    }

    @Override
    public CustomerLogosDto update(long id, CustomerLogosDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        CustomerLogos updatedModel = repository.save(
                mapper.map(dto, CustomerLogos.class)
        );
        return mapper.map(updatedModel, CustomerLogosDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public CustomerLogosDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(repository.findById(id), CustomerLogosDto.class);
    }

    @Override
    public List<CustomerLogosDto> showList() {
        List<CustomerLogos> customerLogosList = repository.findAll();
        List<CustomerLogosDto> customerLogosDtos = new ArrayList<>();
        customerLogosList.forEach(customerLogos -> customerLogosDtos
                .add(mapper
                        .map(customerLogos, CustomerLogosDto.class)));
        return customerLogosDtos;
    }
}

