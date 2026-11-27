package com.app.aulavirtual.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.aulavirtual.entidades.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("""
            SELECT DISTINCT c FROM Curso c
            LEFT JOIN c.estudiantes e
            LEFT JOIN e.persona ep
            LEFT JOIN ep.usuario eu
            LEFT JOIN c.profesor p
            LEFT JOIN p.persona pp
            LEFT JOIN pp.usuario pu
            WHERE eu.username = :usuario OR pu.username = :usuario
            """)
    List<Curso> listarCursosPorUsuario(@Param("usuario") String usuario);
}
