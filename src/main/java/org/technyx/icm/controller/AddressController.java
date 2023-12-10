package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.service.interfaces.AddressService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<AddressDto> save(@RequestBody AddressDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@PathVariable long id, @RequestBody AddressDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }

}
