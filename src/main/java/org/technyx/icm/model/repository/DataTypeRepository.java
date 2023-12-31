package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.DataType;

import java.util.List;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {

    List<DataType> findByDiscriminatorOrderByPriority(String discriminator);
}
