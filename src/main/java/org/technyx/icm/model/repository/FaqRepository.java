package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technyx.icm.model.entity.Faq;

@Repository
public interface FaqRepository  extends JpaRepository<Faq, Long> {
}
