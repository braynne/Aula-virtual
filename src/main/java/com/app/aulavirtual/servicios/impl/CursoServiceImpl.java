package com.app.aulavirtual.servicios.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.aulavirtual.dto.CursoDto;
import com.app.aulavirtual.entidades.Curso;
import com.app.aulavirtual.mappers.CursoMapper;
import com.app.aulavirtual.repositorios.CursoRepository;
import com.app.aulavirtual.servicios.CursoService;
import lombok.AllArgsConstructor;
import com.app.aulavirtual.dto.CursoListaDto;
import com.app.aulavirtual.dto.CursoDetalleDto;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CursoListaDto> listarCursosPorUsuario(String usuario) {

        List<Curso> cursosEntities = cursoRepository.listarCursosPorUsuario(usuario);

        return cursoMapper.entityListToDtoList(cursosEntities);
    }

    @Override 
    @Transactional(readOnly = true) 
    public Optional<CursoDetalleDto> obtenerCursoPorId(Long id) {
        Optional<Curso> entity = cursoRepository.findById(id);
        return entity.map(cursoMapper::entityToDetailDto);
    }

}
