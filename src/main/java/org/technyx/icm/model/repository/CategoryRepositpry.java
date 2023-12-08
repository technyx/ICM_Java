package org.technyx.icm.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.technyx.icm.model.entity.Category;
import org.technyx.icm.model.entity.Post;

import java.io.InterruptedIOException;

public interface CategoryRepositpry extends JpaRepository<Category, Long> {
    Category findByUser(long id);
    void deleteByUser(long id);

}
