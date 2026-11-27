package com.app.aulavirtual.dto;

import lombok.Data;

@Data
public class CursoDetalleDto {
    Long id;
    String nombre;
    String codigo;
    String nombreProfesor;
    Integer cantidadEstudiantes;
}