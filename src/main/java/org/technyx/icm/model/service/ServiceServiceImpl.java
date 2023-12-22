package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ServiceDto;
import org.technyx.icm.model.repository.ServiceRepository;
import org.technyx.icm.model.service.interfaces.ServiceService;
import org.technyx.icm.model.service.validation.interfaces.ServiceValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final ServiceRepository repository;

    private final ServiceValidation validation;

    public ServiceServiceImpl(ServiceRepository repository, ServiceValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public ServiceDto save(ServiceDto dto) {
        org.technyx.icm.model.entity.Service model = mapper.map(dto, org.technyx.icm.model.entity.Service.class);
        validation.validateBaseInfo(model);
        org.technyx.icm.model.entity.Service savedService = repository.save(model);
        return mapper.map(savedService, ServiceDto.class);
    }

    @Override
    public ServiceDto update(long id, ServiceDto dto) {
        dto.setId(id);
        org.technyx.icm.model.entity.Service model = mapper.map(dto, org.technyx.icm.model.entity.Service.class);
        validation.validateBaseInfo(model);
        org.technyx.icm.model.entity.Service udpatedService = repository.save(model);
        return mapper.map(udpatedService, ServiceDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public ServiceDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(repository.findById(id), ServiceDto.class);
    }

    @Override
    public List<ServiceDto> showList() {
        List<org.technyx.icm.model.entity.Service> services = repository.findAll();
        List<ServiceDto> serviceDtos = new ArrayList<>();
        services.forEach(service ->
                serviceDtos.add(mapper.map(service, ServiceDto.class)));
        return serviceDtos;
    }
}
