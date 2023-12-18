package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.FaqDto;
import org.technyx.icm.model.entity.Faq;
import org.technyx.icm.model.repository.FaqRepository;
import org.technyx.icm.model.service.interfaces.FaqService;
import org.technyx.icm.model.service.validation.interfaces.FaqValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FaqServiceImpl implements FaqService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final FaqRepository repository;

    private final FaqValidation validation;

    public FaqServiceImpl(FaqRepository repository, FaqValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public FaqDto save(FaqDto dto) {
        Faq model = mapper.map(dto, Faq.class);
        validation.validateSave(model);
        Faq savedModel = repository.save(model);
        return mapper.map(savedModel, FaqDto.class);
    }

    @Override
    public FaqDto update(long id, FaqDto dto) {
        dto.setId(id);
        Faq model = mapper.map(dto, Faq.class);
        validation.validateUpdate(model);
        Faq updatedModel = repository.save(model);
        return mapper.map(updatedModel, FaqDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public FaqDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(repository.findById(id), FaqDto.class);
    }

    @Override
    public List<FaqDto> showList() {
        List<Faq> faqList = repository.findAll();
        List<FaqDto> faqDtos = new ArrayList<>();
        faqList.forEach(faq -> faqDtos.add(mapper.map(faq, FaqDto.class)));
        return faqDtos;
    }
}
