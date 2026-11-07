package com.app.aulavirtual.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.aulavirtual.dto.CursoDto;
import com.app.aulavirtual.servicios.CursoService;

@RequestMapping("/cursos")
@RestController 
public class CursoController {
    
    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDto>> listarMisCursos(Authentication authentication){
        List<CursoDto> cursos = cursoService.listarCursosPorUsuario(authentication.getName());
        return ResponseEntity.ok(cursos);
    }

}
