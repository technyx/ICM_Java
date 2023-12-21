package org.technyx.icm.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.service.interfaces.PaySlipService;

import java.util.List;

@RestController
@RequestMapping("/payslip")
public class PaySlipController {

    private final PaySlipService service;

    public PaySlipController(PaySlipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaySlipDto> save(@RequestBody PaySlipDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaySlipDto> update(@PathVariable long id, @RequestBody PaySlipDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<PaySlipDto>> showListByUser(@PathVariable String username) {
        return ResponseEntity.ok().body(service.showListByUser(username));
    }

    @GetMapping
    public ResponseEntity<List<PaySlipDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
