package com.app.aulavirtual.dto;

import java.time.OffsetDateTime;

import lombok.*;

@Getter 
@Setter 
@AllArgsConstructor 
public class MensajeForoResponse {
    private Long id;
    private Long cursoId;
    private String texto;
    private OffsetDateTime fecha;
    private String autor;
}
