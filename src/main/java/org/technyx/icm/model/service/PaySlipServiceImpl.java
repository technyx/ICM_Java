package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.entity.PaySlip;
import org.technyx.icm.model.repository.PaySlipRepository;
import org.technyx.icm.model.service.interfaces.PaySlipService;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaySlipServiceImpl implements PaySlipService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private PaySlipRepository repository;

    @Override
    public PaySlipDto save(PaySlipDto dto) {
        PaySlip savedModel = repository.save(
                mapper.map(dto, PaySlip.class)
        );
        return mapper.map(savedModel, PaySlipDto.class);
    }

    @Override
    public PaySlipDto update(PaySlipDto dto) {
        PaySlip updatedModel = repository.save(
                mapper.map(dto, PaySlip.class)
        );
        return mapper.map(updatedModel, PaySlipDto.class);
    }

    @Override
    public void delete(PaySlipDto dto) {
        repository.delete(mapper.map(dto, PaySlip.class));

    }

    @Override
    public PaySlipDto showSingle(PaySlipDto dto) {
        Optional<PaySlip> paySlip = repository.findById(dto.getId());
        return mapper.map(paySlip, PaySlipDto.class);
    }

    @Override
    public List<PaySlipDto> showList() {
        List<PaySlip> paySlipList = repository.findAll();
        List<PaySlipDto> paySlipDtos = new ArrayList<>();
        paySlipList.forEach(paySlip -> paySlipDtos
                .add(mapper
                        .map(paySlip, PaySlipDto.class)));
        return paySlipDtos;
    }
}
