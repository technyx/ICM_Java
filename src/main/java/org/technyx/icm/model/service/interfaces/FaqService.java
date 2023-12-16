package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.FaqDto;

import java.util.List;

public interface FaqService {

    FaqDto save(FaqDto dto);

    FaqDto update(long id, FaqDto dto);

    void delete(long id);

    FaqDto showSingle(long id);

    List<FaqDto> showList();
}
