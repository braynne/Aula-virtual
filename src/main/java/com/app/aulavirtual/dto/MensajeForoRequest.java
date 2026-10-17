package com.app.aulavirtual.dto;

import lombok.*;

@Getter 
@Setter 
@AllArgsConstructor 
public class MensajeForoRequest {
    private Long cursoId;
    private String texto;
}
