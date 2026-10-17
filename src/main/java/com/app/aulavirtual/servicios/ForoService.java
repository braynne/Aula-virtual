package com.app.aulavirtual.servicios;

import java.util.List;
import java.util.Optional;

import com.app.aulavirtual.dto.MensajeForoRequest;
import com.app.aulavirtual.dto.MensajeForoResponse;

public interface ForoService {
    
    public MensajeForoResponse create (
        MensajeForoRequest request,
        String autor
    );

    public Optional<MensajeForoResponse> findById (Long id);

    public List<MensajeForoResponse> list ();

    public List<MensajeForoResponse> listByCurso (Long cursoId);

}
