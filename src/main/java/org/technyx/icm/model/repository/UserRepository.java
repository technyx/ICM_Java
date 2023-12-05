package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            nativeQuery = true
            , value = "select id from tb_user where username = 1"
    )
    Long findIdByUsername(String username);

    boolean existsUserById(long id);

    void deleteByUsername(String username);
}
