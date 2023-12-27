package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.FaqDto;
import org.technyx.icm.model.service.interfaces.FaqService;

import java.util.List;

@RestController
@RequestMapping("/faq")
public class FaqController {

    public final FaqService service;

    public FaqController(FaqService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FaqDto> save(@RequestBody FaqDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaqDto> update(@PathVariable long id, @RequestBody FaqDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaqDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<FaqDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
