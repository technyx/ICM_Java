package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.PartnerDto;

import java.util.List;

public interface PartnerService {

    PartnerDto save(PartnerDto dto);

    PartnerDto update(long id, PartnerDto dto);

    void delete(long id);

    PartnerDto showSingle(long id);

    List<PartnerDto> showList();
}
