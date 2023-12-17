package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/extra-info")
public class ExtraInfoController {

    private final ExtraInfoService service;

    public ExtraInfoController(ExtraInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExtraInfoDto> save(@RequestBody ExtraInfoDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtraInfoDto> update(@PathVariable long id, @RequestBody ExtraInfoDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtraInfoDto> showSingle(@PathVariable long id) {
        return ResponseEntity.ok().body(service.showSingle(id));
    }

    @GetMapping
    public ResponseEntity<List<ExtraInfoDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
