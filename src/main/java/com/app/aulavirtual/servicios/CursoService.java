package com.app.aulavirtual.servicios;

import java.util.List;

import com.app.aulavirtual.dto.*;
import java.util.Optional;

public interface CursoService {

    public List<CursoListaDto> listarCursosPorUsuario(String usuario);
    public Optional<CursoDetalleDto> obtenerCursoPorId(Long id);
}
