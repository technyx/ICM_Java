package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;

@Repository
public interface ExtraInfoRepository extends JpaRepository<ExtraInfo, Long> {

    ExtraInfo findByUser(long id);

    @Query(
            nativeQuery = false
            , value = "select e.address from ExtraInfo e where e.id = ?1"
    )
    Long findAddressById(long user);

    boolean existsById(long id);

}
