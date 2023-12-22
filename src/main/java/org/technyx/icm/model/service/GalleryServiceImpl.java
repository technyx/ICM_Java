package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.GalleryDto;
import org.technyx.icm.model.entity.Gallery;
import org.technyx.icm.model.repository.GalleryRepository;
import org.technyx.icm.model.service.interfaces.GalleryService;
import org.technyx.icm.model.service.validation.interfaces.GalleryValidation;
import org.technyx.icm.model.util.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GalleryServiceImpl implements GalleryService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final GalleryRepository repository;

    private final GalleryValidation validation;

    public GalleryServiceImpl(GalleryRepository repository, GalleryValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public GalleryDto save(GalleryDto dto) {
        Gallery model = mapper.map(dto, Gallery.class);
        validation.validateBaseInfo(model);
        Gallery savedGallery = repository.save(model);
        return mapper.map(savedGallery, GalleryDto.class);
    }

    @Override
    public GalleryDto update(long id, GalleryDto dto) {
        dto.setId(id);
        Gallery model = mapper.map(dto, Gallery.class);
        validation.validateBaseInfo(model);
        Gallery updatedGallery = repository.save(model);
        return mapper.map(updatedGallery, GalleryDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public GalleryDto showSingle(long id) {
        validation.validateExists(id);
        return mapper.map(repository.findById(id), GalleryDto.class);
    }

    @Override
    public List<GalleryDto> showList() {
        List<Gallery> galleries = repository.findAll();
        List<GalleryDto> galleryDtos = new ArrayList<>();
        galleries.forEach(gallery -> galleryDtos.add(mapper.map(gallery, GalleryDto.class)));
        return galleryDtos;
    }
}
