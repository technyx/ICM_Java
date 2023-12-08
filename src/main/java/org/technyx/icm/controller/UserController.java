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
        ResponseEntity<UserWithExtraInfoDto> response = null;
        try {
            UserWithExtraInfoDto savedDto = service.saveWithExtraInfo(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedDto);
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
        return response;
    }

    @PostMapping("/full-data")
    public ResponseEntity<UserWithFullDataDto> saveWithFullData(@RequestBody UserWithFullDataDto dto) {
        ResponseEntity<UserWithFullDataDto> response = null;
        try {
            UserWithFullDataDto savedDto = service.saveWithFullData(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedDto);
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        ResponseEntity<UserDto> response = null;
        try {
            UserDto savedDto = service.update(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedDto);
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody UserDto dto) {
        ResponseEntity<String> response = null;
        try {
            service.delete(dto);
            response = ResponseEntity
                    .status(HttpStatus.OK)
                    .body("given user has been deleted");

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> showAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.showList());
    }
}
