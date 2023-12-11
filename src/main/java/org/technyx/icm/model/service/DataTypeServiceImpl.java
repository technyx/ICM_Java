package org.technyx.icm.model.service;

import org.springframework.stereotype.Service;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.entity.enums.Discriminator;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.interfaces.DataTypeService;

import java.util.List;

@Service
public class DataTypeServiceImpl implements DataTypeService {

    private final DataTypeRepository repository;

    public DataTypeServiceImpl(DataTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataType save(DataType dataType) {
        return repository.save(dataType);
    }

    @Override
    public List<DataType> findByDiscriminator(String discriminator) {
        return repository.findByDiscriminatorOrderByPriority(Discriminator.valueOf(discriminator));
    }
}
