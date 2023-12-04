package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.ExtraInfoDto;

import java.util.List;

public interface ExtraInfoService {

    ExtraInfoDto save(ExtraInfoDto dto);

    ExtraInfoDto update(ExtraInfoDto dto);

    void delete(ExtraInfoDto dto);

    ExtraInfoDto showSingle(ExtraInfoDto dto);

    List<ExtraInfoDto> showList();
}
