package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.CustomerLogos;

@Repository
public interface CustomerLogosRepository extends JpaRepository<CustomerLogos, Long> {

    void deleteById(long id);
}
