package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.FileDto;
import org.technyx.icm.model.service.interfaces.FileService;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FileDto> save(@RequestBody FileDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileDto> update(@PathVariable long id, @RequestBody FileDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<FileDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
