package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.entity.PaySlip;
import org.technyx.icm.model.repository.PaySlipRepository;
import org.technyx.icm.model.service.interfaces.PaySlipService;
import org.technyx.icm.model.service.validation.interfaces.PaySlipValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaySlipServiceImpl implements PaySlipService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final PaySlipRepository repository;

    private final PaySlipValidation validation;

    public PaySlipServiceImpl(PaySlipRepository repository, PaySlipValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public PaySlipDto save(PaySlipDto dto) {
        PaySlip model = mapper.map(dto, PaySlip.class);
        validation.validateSave(model);
        PaySlip savedModel = repository.save(model);
        return mapper.map(savedModel, PaySlipDto.class);
    }

    @Override
    public PaySlipDto update(long id, PaySlipDto dto) {
        dto.setId(id);
        PaySlip model = mapper.map(dto, PaySlip.class);
        validation.validateSave(model);
        PaySlip updatedModel = repository.save(model);
        return mapper.map(updatedModel, PaySlipDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public PaySlipDto showSingle(long id) {
        validation.validateExists(id);
        Optional<PaySlip> paySlip = repository.findById(id);
        return mapper.map(paySlip, PaySlipDto.class);
    }

    @Override
    public List<PaySlipDto> showListByUser(long userId) {
        List<PaySlip> paySlipList = repository.findAllByUser(userId);
        List<PaySlipDto> paySlipDtos = new ArrayList<>();
        paySlipList.forEach(paySlip -> paySlipDtos
                .add(mapper
                        .map(paySlip, PaySlipDto.class)));
        return paySlipDtos;
    }

    @Override
    public List<PaySlipDto> showList() {
        List<PaySlip> paySlipList = repository.findAllOrderByDate();
        List<PaySlipDto> paySlipDtos = new ArrayList<>();
        paySlipList.forEach(paySlip -> paySlipDtos
                .add(mapper
                        .map(paySlip, PaySlipDto.class)));
        return paySlipDtos;
    }
}
