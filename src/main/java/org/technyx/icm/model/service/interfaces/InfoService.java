package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.InfoDto;

import java.util.List;

public interface InfoService {

    InfoDto save(InfoDto dto);

    InfoDto update(long id, InfoDto dto);

    void delete(long id);

    InfoDto showSingle(long id);

    List<InfoDto> showList(String discriminator);
}
