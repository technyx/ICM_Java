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
import org.technyx.icm.model.service.validation.interfaces.LogoValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LogoServiceImpl implements LogoService {
    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final FileService service;

    private final LogoValidation validation;

    public LogoServiceImpl(FileService service, LogoValidation validation) {
        this.service = service;
        this.validation = validation;
    }

    @Override
    public LogoDto save(LogoDto dto) {
        validation.validateSave(dto);
        FileDto fileDto = mapper.map(dto, FileDto.class);
        fileDto.setDiscriminator("LOGO_FILE");
        FileDto savedFileDto = service.save(fileDto);
        return mapper.map(savedFileDto, LogoDto.class);
    }

    @Override
    public LogoDto update(long id, LogoDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        FileDto fileDto = mapper.map(dto, FileDto.class);
        fileDto.setDiscriminator("LOGO_FILE");
        FileDto savedFileDto = service.save(fileDto);
        return mapper.map(savedFileDto, LogoDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        service.delete(id);
    }

    @Override
    public LogoDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(service.showSingle(id), LogoDto.class);
    }

    @Override
    public List<LogoDto> showList(String discriminator) {
        List<FileDto> fileDtoList = service.showList(discriminator);
        List<LogoDto> logoDtos = new ArrayList<>();
        fileDtoList.forEach(logo -> logoDtos
                .add(mapper
                        .map(logo, LogoDto.class)));
        return logoDtos;
    }
}

