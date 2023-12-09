package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.ExtraInfoDto;

import java.util.List;

public interface ExtraInfoService {

    ExtraInfoDto save(ExtraInfoDto dto);

    ExtraInfoDto update(long id, ExtraInfoDto dto);

    void delete(long id);

    ExtraInfoDto showSingle(long id);

    List<ExtraInfoDto> showList();
}
