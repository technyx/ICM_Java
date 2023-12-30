package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.service.interfaces.AuthenticateService;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {

    private final AuthenticateService service;

    public AuthenticateController(AuthenticateService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

}
