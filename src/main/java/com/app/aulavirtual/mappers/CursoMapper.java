package com.app.aulavirtual.mappers;

import java.util.List;

import org.mapstruct.*;
import com.app.aulavirtual.dto.*;
import com.app.aulavirtual.entidades.*;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoDto entityToDto(Curso curso);
    Curso dtoToEntity(CursoDto cursoDto);
    CursoListaDto entityToListDto(Curso curso);
    List<CursoListaDto> entityListToDtoList(List<Curso> cursos);
    @Mapping (
        target = "nombreProfesor",
        expression = "java(curso.getProfesor().getPersona().getNombres() +\" \"+ curso.getProfesor().getPersona().getApellidos())"
    )
    @Mapping (
        target = "cantidadEstudiantes",
        expression = "java(curso.getEstudiantes().size())"
    )
    CursoDetalleDto entityToDetailDto(Curso curso);
    
}
