package com.app.aulavirtual.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.app.aulavirtual.dto.MensajeForoRequest;
import com.app.aulavirtual.dto.MensajeForoResponse;
import com.app.aulavirtual.servicios.ForoService;
import lombok.AllArgsConstructor;


@RestController 
@AllArgsConstructor 
@RequestMapping("/api/foros")
public class ForoController {

    public ForoService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensajeForoResponse create (
        @RequestBody MensajeForoRequest request,
        Authentication authentication
    ) {
        return service.create (
            request, authentication.getName()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeForoResponse> getById (
        @PathVariable Long id
    ) {
        var response = service.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<MensajeForoResponse> list () {
        return service.list();
    }

    @GetMapping("/curso/{cursoId}")
    public List<MensajeForoResponse> listByCurso (
        @PathVariable Long cursoId
    ) {
        return service.listByCurso(cursoId);
    }
    
}
