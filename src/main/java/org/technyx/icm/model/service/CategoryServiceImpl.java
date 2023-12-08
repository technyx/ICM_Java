package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.dtos.CategoryDto;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.Category;
import org.technyx.icm.model.repository.CategoryRepositpry;
import org.technyx.icm.model.service.interfaces.CategoryService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();
    @Autowired
    private CategoryRepositpry repository;

    @Override
    public CategoryDto save(CategoryDto dto) {
        Category savedModel = repository.save(
                mapper.map(dto, Category.class)
        );
        return mapper.map(savedModel, CategoryDto.class);

    }

    @Override
    public CategoryDto update(CategoryDto dto) {
        Category updatedModel = repository.save(
                mapper.map(dto, Category.class)
        );
        return mapper.map(updatedModel, CategoryDto.class);
    }

    @Override
    public void delete(CategoryDto dto) {
        repository.deleteByUser(dto.getCategoryId());

    }

    @Override
    public CategoryDto showSingle(CategoryDto dto) {
        Optional<Category> category = repository.findById(dto.getCategoryId());
        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> showList() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> modelList = repository.findAll();
        modelList.forEach(category -> categoryDtos.add(mapper.map(modelList,CategoryDto.class)));
        return categoryDtos;

    }
}
