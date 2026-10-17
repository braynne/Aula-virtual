package com.app.aulavirtual.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.aulavirtual.dto.MensajeForoRequest;
import com.app.aulavirtual.dto.MensajeForoResponse;
import com.app.aulavirtual.entidades.MensajeForo;
import com.app.aulavirtual.mapper.MensajeForoMapper;
import com.app.aulavirtual.repositorios.MensajeForoRepository;
import com.app.aulavirtual.servicios.ForoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ForoServiceImpl implements ForoService {

    private MensajeForoRepository repository;

    @Override
    public MensajeForoResponse create (
        MensajeForoRequest request,
        String autor
    ) {
        var entity = MensajeForoMapper.toEntity(request, autor);
        MensajeForo saved = repository.save(entity);
        return MensajeForoMapper.toResponse(saved);
    }

    @Override
    public Optional<MensajeForoResponse> findById (Long id) {
        var entity = repository.findById(id);
        return entity.map(MensajeForoMapper::toResponse);
    }

    @Override
    public List<MensajeForoResponse> list () {
        return repository.findAll()
            .stream()
            .map(MensajeForoMapper::toResponse)
            .toList();
    }

    @Override
    public List<MensajeForoResponse> listByCurso (Long cursoId) {
        return repository.findByCursoIdOrderByFechaAsc(cursoId)
            .stream()
            .map(MensajeForoMapper::toResponse)
            .toList();
    }
    
}
