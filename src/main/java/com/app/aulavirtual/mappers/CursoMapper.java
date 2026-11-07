package com.app.aulavirtual.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.aulavirtual.dto.CursoDto;
import com.app.aulavirtual.entidades.Curso;

@Mapper 
public interface CursoMapper {

    CursoDto entityToDto(Curso curso);

    Curso dtoToEntity(CursoDto cursoDto);

    List<CursoDto> entityListToDtoList(List<Curso> cursos);
}
