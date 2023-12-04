package org.technyx.icm.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;

@Repository
public interface ExtraInfoRepository extends CrudRepository<ExtraInfo, Integer> {
}
