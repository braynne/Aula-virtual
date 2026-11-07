package com.app.aulavirtual.dto;

import java.util.List;

import com.app.aulavirtual.entidades.Persona;

import lombok.Data;

@Data 
public class EstudianteDto {

    private Long id;

    private Double codigo;

    private Persona persona;
    
    private List<CursoDto> cursos;

}
