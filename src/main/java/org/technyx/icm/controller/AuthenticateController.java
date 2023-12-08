package org.technyx.icm.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.service.interfaces.AuthenticateService;

@RestController
@RequestMapping("/app/v001/auth")
public class AuthenticateController {

    @Autowired
    private AuthenticateService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto dto) {
        ResponseEntity<RegisterDto> response = null;
        try {
            RegisterDto savedDto = service.register(dto);
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

    @GetMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto dto) {
        ResponseEntity<LoginDto> response = null;
        try {
            LoginDto loginDto = service.login(dto);
            if (loginDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.OK)
                        .body(loginDto);
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
        return response;
    }

}
