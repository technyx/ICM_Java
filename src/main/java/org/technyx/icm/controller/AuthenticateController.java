package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.service.interfaces.AuthenticateService;

@RestController
@RequestMapping("/app/v001/auth")
public class AuthenticateController {

    @Autowired
    private AuthenticateService service;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterDto dto) {
        ResponseEntity<String> response = null;
        try {
            RegisterDto savedDto = service.register(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given user has been created");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }
}
