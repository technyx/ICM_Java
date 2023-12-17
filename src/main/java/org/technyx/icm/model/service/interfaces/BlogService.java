package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.BlogDto;

import java.util.List;

public interface BlogService {

    BlogDto save(BlogDto dto);

    BlogDto update(long id, BlogDto dto);

    void delete(long id);

    BlogDto showSingle(long id);

    List<BlogDto> showList();
}
