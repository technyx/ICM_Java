package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technyx.icm.model.entity.DataType;

import java.util.List;

public interface DataTypeRepository extends JpaRepository<DataType, Long> {

    List<DataType> findByDiscriminator(String discriminator);
}
