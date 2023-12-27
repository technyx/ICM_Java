package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.InfoDto;
import org.technyx.icm.model.service.interfaces.InfoService;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService service;

    private final static String ABOUT = "ABOUT";

    private final static String CONTACT = "CONTACT";

    public InfoController(InfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InfoDto> save(@RequestBody InfoDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoDto> update(@PathVariable long id, @RequestBody InfoDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoDto> showSingle(@PathVariable long id) {
        return ResponseEntity.ok().body(service.showSingle(id));
    }

    @GetMapping("/about")
    public ResponseEntity<List<InfoDto>> showAllAbout() {
        return ResponseEntity
                .ok()
                .body(service.showList(ABOUT));
    }

    @GetMapping("/contact")
    public ResponseEntity<List<InfoDto>> showAllContact() {
        return ResponseEntity
                .ok()
                .body(service.showList(CONTACT));
    }
}
