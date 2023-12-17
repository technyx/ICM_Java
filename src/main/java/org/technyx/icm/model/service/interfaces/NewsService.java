package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.NewsDto;
import org.technyx.icm.model.entity.Content;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    NewsDto save(NewsDto dto);

    NewsDto update(long id, NewsDto dto);

    void delete(long id);

    NewsDto showSingle(long id);

    List<NewsDto> showList();
}
