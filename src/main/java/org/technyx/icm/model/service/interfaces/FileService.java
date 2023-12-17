package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.FileDto;

import java.util.List;

public interface FileService {

    FileDto save(FileDto dto);

    FileDto update(long id, FileDto dto);

    void delete(long id);

    FileDto showSingle(long id);

    List<FileDto> showList(String discriminator);
}
