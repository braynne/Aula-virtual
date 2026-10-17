package com.app.aulavirtual.dto;

import lombok.*;

@Getter 
@Setter 
@AllArgsConstructor 
public class LoginRequest {
    public String usuario;
    public String contrasena;
}