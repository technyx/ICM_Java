package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.CustomerLogosDto;
import org.technyx.icm.model.service.interfaces.CustomerLogosService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/customerLogos")
public class CustomerLogosController {

    @Autowired
    private CustomerLogosService service;

    @PostMapping
    public ResponseEntity<CustomerLogosDto> save(@RequestBody CustomerLogosDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerLogosDto> update(@PathVariable long id, @RequestBody CustomerLogosDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerLogosDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
