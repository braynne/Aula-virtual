package com.app.aulavirtual.servicios.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.app.aulavirtual.dto.CursoDto;
import com.app.aulavirtual.entidades.Curso;
import com.app.aulavirtual.mappers.CursoMapper;
import com.app.aulavirtual.repositorios.CursoRepository;
import com.app.aulavirtual.servicios.CursoService;

@Service 
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
        this.cursoMapper = Mappers.getMapper(CursoMapper.class);
    }

    @Override
    public List<CursoDto> listarCursosPorUsuario(String usuario) {

        List<Curso> cursosEntities = cursoRepository.listarCursosPorUsuario(usuario);
        System.out.println(cursosEntities.size());
        System.err.println(usuario);

        return cursoMapper.entityListToDtoList(cursosEntities) ;
    }

}
