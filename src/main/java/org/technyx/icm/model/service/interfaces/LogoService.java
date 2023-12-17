package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.LogoDto;

import java.util.List;

public interface LogoService {

    LogoDto save(LogoDto dto);

    LogoDto update(long id, LogoDto dto);

    void delete(long id);

    LogoDto showSingle(long id);

    List<LogoDto> showList(String discriminator);
}
