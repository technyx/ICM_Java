package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.FileDto;
import org.technyx.icm.model.entity.File;
import org.technyx.icm.model.repository.FileRepository;
import org.technyx.icm.model.service.interfaces.FileService;
import org.technyx.icm.model.service.validation.interfaces.FileValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final FileRepository repository;

    private final FileValidation validation;

    public FileServiceImpl(FileRepository repository, FileValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public FileDto save(FileDto dto) {
        validation.validateSave(dto);
        File savedModel = repository.save(
                mapper.map(dto, File.class)
        );
        return mapper.map(savedModel, FileDto.class);
    }

    @Override
    public FileDto update(long id, FileDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        File updatedModel = repository.save(
                mapper.map(dto, File.class)
        );
        return mapper.map(updatedModel, FileDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public FileDto showSingle(long id) {
        validation.validateExists(id);
        return mapper
                .map(repository.findById(id), FileDto.class);
    }

    @Override
    public List<FileDto> showList(String discriminator) {
        List<File> fileList = repository.findAll();
        List<FileDto> fileDtos = new ArrayList<>();
        fileList.forEach(file -> fileDtos
                .add(mapper
                        .map(file, FileDto.class)));
        return fileDtos;
    }
}
