//package org.technyx.icm.model.service;
//
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.technyx.icm.model.dtos.FileDto;
//import org.technyx.icm.model.entity.File;
//import org.technyx.icm.model.repository.FileRepository;
//import org.technyx.icm.model.service.interfaces.FileService;
//import org.technyx.icm.model.util.ModelMapperConfig;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class FileServiceImpl implements FileService {
//
//    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();
//
//    @Autowired
//    private FileRepository repository;
//
//    @Override
//    public FileDto save(FileDto dto) {
//        File savedModel = repository.save(
//                mapper.map(dto, File.class)
//        );
//        return mapper.map(savedModel, FileDto.class);
//    }
//
//    @Override
//    public FileDto update(FileDto dto) {
//        File updatedModel = repository.save(
//                mapper.map(dto, File.class)
//        );
//        return mapper.map(updatedModel, FileDto.class);
//    }
//
//    @Override
//    public void delete(FileDto dto) {
//        repository.delete(mapper.map(dto, File.class));
//    }
//
//    @Override
//    public FileDto showSingle(FileDto dto) {
//        Optional<File> file = repository.findById(dto.getId());
//        return mapper.map(file, FileDto.class);
//    }
//
//    @Override
//    public List<FileDto> showList() {
//        List<File> fileList = repository.findAll();
//        List<FileDto> fileDtos = new ArrayList<>();
//        fileList.forEach(file -> fileDtos
//                .add(mapper
//                        .map(file, FileDto.class)));
//        return fileDtos;
//    }
//}
