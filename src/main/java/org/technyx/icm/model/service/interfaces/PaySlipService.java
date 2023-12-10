package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.PaySlipDto;

import java.util.List;

public interface PaySlipService {

    PaySlipDto save(PaySlipDto dto);

    PaySlipDto update(long id, PaySlipDto dto);

    void delete(long id);

    PaySlipDto showSingle(long id);

    List<PaySlipDto> showList();
}
