package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.PostDto;
import org.technyx.icm.model.entity.Post;

import java.util.List;

public interface PostService {
    PostDto save(PostDto dto);

    PostDto update(PostDto dto);

    void delete(PostDto dto);

    PostDto showSingle(PostDto dto);

    List<PostDto> showList();

}
