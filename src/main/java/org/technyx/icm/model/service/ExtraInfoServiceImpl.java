package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;

import java.util.List;

@Service
@Transactional
public class ExtraInfoServiceImpl implements ExtraInfoService {

    @Override
    public ExtraInfoDto save(ExtraInfoDto dto) {
        return null;
    }

    @Override
    public ExtraInfoDto update(ExtraInfoDto dto) {
        return null;
    }

    @Override
    public void delete(ExtraInfoDto dto) {

    }

    @Override
    public ExtraInfoDto showSingle(ExtraInfoDto dto) {
        return null;
    }

    @Override
    public List<ExtraInfoDto> showList() {
        return null;
    }
}
