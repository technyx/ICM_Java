package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.FileDto;
import org.technyx.icm.model.dtos.LogoDto;
import org.technyx.icm.model.entity.File;
import org.technyx.icm.model.repository.FileRepository;
import org.technyx.icm.model.service.interfaces.FileService;
import org.technyx.icm.model.service.interfaces.LogoService;
import org.technyx.icm.model.service.validation.interfaces.FileValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LogoServiceImpl implements LogoService {
    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final FileRepository repository;

    private final FileValidation validation;

    private final static String DISCRIMINATOR = "LOGO_FILE";

    public LogoServiceImpl(FileRepository repository, FileValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public LogoDto save(LogoDto dto) {
        File model = mapper.map(dto, File.class);
        model.setDiscriminator(DISCRIMINATOR);
        validation.validateSave(model);
        File savedFile = repository.save(model);
        return mapper.map(savedFile, LogoDto.class);
    }

    @Override
    public LogoDto update(long id, LogoDto dto) {
        dto.setId(id);
        File model = mapper.map(dto, File.class);
        model.setDiscriminator(DISCRIMINATOR);
        validation.validateSave(model);
        File updatedFile = repository.save(model);
        return mapper.map(updatedFile, LogoDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public LogoDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(repository.findById(id), LogoDto.class);
    }

    @Override
    public List<LogoDto> showList() {
        List<File> fileList = repository.findAllByDiscriminator(DISCRIMINATOR);
        List<LogoDto> logoDtos = new ArrayList<>();
        fileList.forEach(logo -> logoDtos
                .add(mapper
                        .map(logo, LogoDto.class)));
        return logoDtos;
    }
}

