package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.PaySlipDto;

import java.util.List;

public interface PaySlipService {

    PaySlipDto save(PaySlipDto dto);

    PaySlipDto update(PaySlipDto dto);

    void delete(PaySlipDto dto);

    PaySlipDto showSingle(PaySlipDto dto);

    List<PaySlipDto> showList();
}
