package org.technyx.icm.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    boolean existsUserById(long id);
}
