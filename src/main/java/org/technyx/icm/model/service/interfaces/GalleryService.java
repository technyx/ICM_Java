package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.GalleryDto;

import java.util.List;

public interface GalleryService {

    GalleryDto save(GalleryDto dto);

    GalleryDto update(long id, GalleryDto dto);

    void delete(long id);

    GalleryDto showSingle(long id);

    List<GalleryDto> showList();
}
