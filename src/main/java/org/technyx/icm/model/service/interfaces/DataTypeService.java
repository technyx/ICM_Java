package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.entity.DataType;

import java.util.List;

public interface DataTypeService {

    DataType save(DataType dataType);

    List<DataType> findByDiscriminator(String discriminator);
}
