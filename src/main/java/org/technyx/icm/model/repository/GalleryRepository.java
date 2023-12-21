package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
