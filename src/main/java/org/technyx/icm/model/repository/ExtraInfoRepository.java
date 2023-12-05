package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;

import java.util.List;

@Repository
public interface ExtraInfoRepository extends JpaRepository<ExtraInfo, Integer> {

    ExtraInfo findByUser(long id);

    void deleteByUser(long id);

    @Query(
            nativeQuery = true
            , value = "select * from tb_extra_info where fk_user = 1"
    )
    Long findIdByUserId(long userId);
}
