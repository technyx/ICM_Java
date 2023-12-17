package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.dtos.LogoDto;
import org.technyx.icm.model.entity.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findAllByDiscriminator(String discriminator);
}
