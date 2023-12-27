package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.ServiceDto;
import org.technyx.icm.model.service.interfaces.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceDto> save(@RequestBody ServiceDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> update(@PathVariable long id, @RequestBody ServiceDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> showSingle(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
