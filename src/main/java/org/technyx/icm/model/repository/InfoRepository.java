package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.Info;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findAllByDiscriminator(String discriminator);
}
