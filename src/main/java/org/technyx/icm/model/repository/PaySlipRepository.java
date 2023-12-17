package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.PaySlip;

import java.sql.Date;

@Repository
public interface PaySlipRepository extends JpaRepository<PaySlip, Long> {
}
