package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.service.interfaces.UserService;

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
}
