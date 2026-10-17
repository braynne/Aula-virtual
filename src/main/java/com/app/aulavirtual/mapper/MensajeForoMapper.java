package com.app.aulavirtual.mapper;

import java.time.OffsetDateTime;

import com.app.aulavirtual.dto.MensajeForoRequest;
import com.app.aulavirtual.dto.MensajeForoResponse;
import com.app.aulavirtual.entidades.MensajeForo;

public class MensajeForoMapper {

    public static MensajeForo toEntity (
        MensajeForoRequest request,
        String autor
    ) {
        var fecha = OffsetDateTime.now();
        return new MensajeForo (
            null,
            request.getCursoId(),
            request.getTexto(),
            fecha,
            autor
        );
    }

    public static MensajeForoResponse toResponse (
        MensajeForo entity
    ) {
        return new MensajeForoResponse (
            entity.getId(),
            entity.getCursoId(),
            entity.getTexto(),
            entity.getFecha(),
            entity.getAutor()
        );
    } 
}
