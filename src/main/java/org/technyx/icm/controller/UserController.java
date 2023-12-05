package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.service.interfaces.UserService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> fullSave(@RequestBody FullUserDto dto) {
        ResponseEntity<String> response = null;
        try {
            FullUserDto savedDto = service.fullSave(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given full-user has been created");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UserDto dto) {
        ResponseEntity<String> response = null;
        try {
            UserDto savedDto = service.update(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given user has been updated");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody UserDto dto) {
        ResponseEntity<String> response = null;
        try {
            service.delete(dto);
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
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
