package org.technyx.icm.model.service;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.PostDto;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.Post;
import org.technyx.icm.model.repository.PostRepository;
import org.technyx.icm.model.service.interfaces.PostService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();
    @Autowired
    private PostRepository repository;

    @Override
    public PostDto save(PostDto dto){
        Post savedModel = repository.save(
                mapper.map(dto, Post.class)
        );
        return mapper.map(savedModel, PostDto.class);

    }

    @Override
    public PostDto update(PostDto dto) {

        Post updatedModel = repository.save(
                mapper.map(dto, Post.class)
        );
        return mapper.map(updatedModel, PostDto.class);
    }

    @Override
    public void delete(PostDto dto) {
        repository.deleteByUser(dto.getPostId());
    }

    @Override
    public PostDto showSingle(PostDto dto) {
        Optional<Post> post = repository.findById(dto.getPostId());
        return mapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> showList() {
        List<PostDto> PostDtos = new ArrayList<>();
        List <Post> modelList = repository.findAll();
        modelList.forEach(post -> PostDtos.add(mapper.map(post,PostDto.class)));
        return PostDtos;
    }

}
