package com.app.aulavirtual.servicios;

import java.util.List;

import com.app.aulavirtual.dto.CursoDto;

public interface CursoService {

    public List<CursoDto> listarCursosPorUsuario(String usuario);

}
