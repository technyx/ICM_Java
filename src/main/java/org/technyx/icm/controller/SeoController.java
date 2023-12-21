package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.SeoDto;
import org.technyx.icm.model.service.interfaces.SeoService;

import java.util.List;

@RestController
@RequestMapping("/seo")
public class SeoController {

    private final SeoService service;

    public SeoController(SeoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SeoDto> save(@RequestBody SeoDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeoDto> update(@PathVariable long id, @RequestBody SeoDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeoDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<SeoDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
