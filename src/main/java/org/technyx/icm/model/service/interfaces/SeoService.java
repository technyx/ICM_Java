package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.SeoDto;

import java.util.List;

public interface SeoService {

    SeoDto save(SeoDto dto);

    SeoDto update(long id, SeoDto dto);

    void delete(long id);

    SeoDto showSingle(long id);

    List<SeoDto> showList();
}
