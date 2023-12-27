package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.CourseDto;
import org.technyx.icm.model.service.interfaces.CourseService;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable long id, @RequestBody CourseDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
