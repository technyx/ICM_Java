package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.FileDto;

import java.util.List;

public interface FileService {

    FileDto save(FileDto dto);

    FileDto update(FileDto dto);

    void delete(FileDto dto);

    FileDto showSingle(FileDto dto);

    List<FileDto> showList();
}
