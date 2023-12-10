package org.technyx.icm.model.service;

import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.interfaces.DataTypeService;

import java.util.List;

public class DataTypeServiceImpl implements DataTypeService {

    private final DataTypeRepository repository;

    public DataTypeServiceImpl(DataTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DataType> findByDiscriminator(String discriminator) {
        return repository.findByDiscriminator(discriminator);
    }
}
