package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.PaySlip;

import java.util.List;

@Repository
public interface PaySlipRepository extends JpaRepository<PaySlip, Long> {

    @Query(
            nativeQuery = true,
            value = """
                    select * from tb_pay_slip where fk_user = ?1
                    """
    )
    List<PaySlip> findAllByUserId(long userId);

    @Query(
            nativeQuery = true,
            value = """
                    select * from tb_pay_slip as ps
                    join tb_user as us on us.c_id = ps.fk_user
                    where us.c_username = ?1
                    """
    )
    List<PaySlip> findAllByUserUsername(String username);


    @Query(
            nativeQuery = true,
            value = """
                    select * from tb_pay_slip order by c_date desc
                    """
    )
    List<PaySlip> findAllOrderByDate();
}
