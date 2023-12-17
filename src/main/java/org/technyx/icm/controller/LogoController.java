package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.LogoDto;
import org.technyx.icm.model.service.interfaces.LogoService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/customerLogos")
public class LogoController {

    private final LogoService service;

    public LogoController(LogoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LogoDto> save(@RequestBody LogoDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogoDto> update(@PathVariable long id, @RequestBody LogoDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/show-single/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-list/{discriminator}")
    public ResponseEntity<List<LogoDto>> showAll(@PathVariable String discriminator) {
        return ResponseEntity
                .ok()
                .body(service.showList(discriminator));
    }
}
