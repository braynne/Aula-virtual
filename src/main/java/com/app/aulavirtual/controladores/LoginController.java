package com.app.aulavirtual.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.app.aulavirtual.dto.LoginRequest;
import com.app.aulavirtual.dto.LoginResponse;
import com.app.aulavirtual.servicios.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/auth")
@RestController
public class LoginController {

    public AuthService authService;

    public LoginController(AuthService authService){
        this.authService = authService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

        String token = authService.login(loginRequest.getUsuario(), loginRequest.getContrasena());

        return ResponseEntity.ok(new LoginResponse(token));
    }

}
