package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.service.interfaces.PaySlipService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/payslip")
public class PaySlipController {

    @Autowired
    private PaySlipService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PaySlipDto dto) {
        ResponseEntity<String> response = null;
        try {
            PaySlipDto savedDto = service.save(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given payslip has been created");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody PaySlipDto dto) {
        ResponseEntity<String> response = null;
        try {
            PaySlipDto updatedDto = service.update(dto);
            if (updatedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given payslip has been updated");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody PaySlipDto dto) {
        ResponseEntity<String> response = null;
        try {
            service.delete(dto);
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("given payslip has been deleted");

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<PaySlipDto>> showAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.showList());
    }
}
