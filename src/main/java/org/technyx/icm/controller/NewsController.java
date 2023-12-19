package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.NewsDto;
import org.technyx.icm.model.service.NewsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsServiceImpl service;

    public NewsController(NewsServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NewsDto> save(@RequestBody NewsDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> update(@PathVariable long id, @RequestBody NewsDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<NewsDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
