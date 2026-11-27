package com.app.aulavirtual.dto;

import java.util.List;

import lombok.Data;

@Data
public class CursoDto {

    private Long id;

    private String nombre;

    private String codigo;

    private List<EstudianteDto> estudiantes;

    private ProfesorDto profesor;

}
