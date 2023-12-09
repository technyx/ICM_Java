package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.UserWithExtraInfoDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.dtos.UserWithFullDataDto;
import org.technyx.icm.model.service.interfaces.UserService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/extra-info")
    public ResponseEntity<UserWithExtraInfoDto> saveWithExtraInfo(@RequestBody UserWithExtraInfoDto dto) {
        return ResponseEntity.ok(service.saveWithExtraInfo(dto));
    }

    @PostMapping("/full-data")
    public ResponseEntity<UserWithFullDataDto> saveWithFullData(@RequestBody UserWithFullDataDto dto) {
        return ResponseEntity.ok(service.saveWithFullData(dto));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody UserDto dto) {
        service.delete(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> showAll() {
        return ResponseEntity
                .ok()
                .body(service.showList());
    }
}
