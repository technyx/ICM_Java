package org.technyx.icm.model.service;

import org.springframework.stereotype.Service;
import org.technyx.icm.model.entity.DataType;
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
    public DataType save(DataType model) {
        return repository.save(model);
    }

    @Override
    public DataType update(long id, DataType model) {
        model.setId(id);
        return repository.save(model);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DataType> findByDiscriminator(String discriminator) {
        return repository.findByDiscriminatorOrderByPriority(discriminator);
    }
}
