package com.app.aulavirtual.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.aulavirtual.dto.CursoDto;
import com.app.aulavirtual.servicios.CursoService;
import com.app.aulavirtual.dto.CursoListaDto;
import com.app.aulavirtual.dto.CursoDetalleDto;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/cursos")
@RestController 
public class CursoController {
    
    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("/mis-cursos")
    public ResponseEntity<List<CursoListaDto>> listarMisCursos (
        Authentication authentication
    ){
        List<CursoListaDto> cursos = cursoService.listarCursosPorUsuario (
            authentication.getName()
        );
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDetalleDto> obtenerPorId (
        Authentication authentication,
        @PathVariable Long id
    ) {
        var response = cursoService.obtenerCursoPorId(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else return ResponseEntity.notFound().build();
    }

}
