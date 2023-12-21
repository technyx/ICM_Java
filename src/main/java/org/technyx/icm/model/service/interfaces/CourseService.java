package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto save(CourseDto dto);

    CourseDto update(long id, CourseDto dto);

    void delete(long id);

    CourseDto showSingle(long id);

    List<CourseDto> showList();
}
