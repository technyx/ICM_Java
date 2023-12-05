package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.ExtraInfo;

import java.util.List;

@Repository
public interface ExtraInfoRepository extends JpaRepository<ExtraInfo, Long> {

    ExtraInfo findByUser(long id);

    void deleteByUser(long id);

    @Query(
            nativeQuery = false
            , value = "select e.id from ExtraInfo e where e.user = ?1"
    )
    Long findIdByUserId(long userId);

    boolean existsById(long id);
}
