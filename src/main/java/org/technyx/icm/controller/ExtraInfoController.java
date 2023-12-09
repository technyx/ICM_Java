package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ExtraInfoDto> save(@RequestBody ExtraInfoDto dto) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<ExtraInfoDto> update(@RequestBody ExtraInfoDto dto) {
        return ResponseEntity.ok().body(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody ExtraInfoDto dto) {
        service.delete(dto);
        return ResponseEntity.ok().build();
    }

    /*
     * TODO: remember to implement showSingle
     * */

    @GetMapping
    public ResponseEntity<List<ExtraInfoDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
