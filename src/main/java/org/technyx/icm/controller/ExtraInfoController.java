package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/extra-info")
public class ExtraInfoController {

    @Autowired
    private ExtraInfoService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ExtraInfoDto dto) {
        ResponseEntity<String> response = null;
        try {
            ExtraInfoDto savedDto = service.save(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given extra-info has been created");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ExtraInfoDto dto) {
        ResponseEntity<String> response = null;
        try {
            ExtraInfoDto updatedDto = service.update(dto);
            if (updatedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given extra-info has been updated");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody ExtraInfoDto dto) {
        ResponseEntity<String> response = null;
        try {
            service.delete(dto);
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("given extra-info has been deleted");

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    /*
    * TODO: remember to implement showSingle
    * */

    @GetMapping
    public ResponseEntity<List<ExtraInfoDto>> showAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.showList());
    }
}
