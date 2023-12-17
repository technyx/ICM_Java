package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technyx.icm.model.entity.ExtraInfo;

public interface ExtraInfoRepository extends JpaRepository<ExtraInfo, Long> {
}
