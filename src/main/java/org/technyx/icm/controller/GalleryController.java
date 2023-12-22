package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.FileDto;
import org.technyx.icm.model.dtos.GalleryDto;
import org.technyx.icm.model.service.interfaces.GalleryService;

import java.util.List;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService service;

    public GalleryController(GalleryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GalleryDto> save(@RequestBody GalleryDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GalleryDto> update(@PathVariable long id, @RequestBody GalleryDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GalleryDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
