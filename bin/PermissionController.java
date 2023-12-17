package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.PermissionDto;
import org.technyx.icm.model.service.interfaces.PermissionService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/permission")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PermissionDto> save(@RequestBody PermissionDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionDto> update(@PathVariable long id, @RequestBody PermissionDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PermissionDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
