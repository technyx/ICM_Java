package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.Seo;

@Repository
public interface SeoRepository extends JpaRepository<Seo, Long> {

    Seo findById(long id);
}
