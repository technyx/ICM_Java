package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.PaySlip;

import java.sql.Date;
import java.util.List;

@Repository
public interface PaySlipRepository extends JpaRepository<PaySlip, Long> {

    @Query(
            nativeQuery = true,
            value = "select * from tb_pay_slip where fk_user = ?1"
    )
    List<PaySlip> findAllByUser(String username);
}
