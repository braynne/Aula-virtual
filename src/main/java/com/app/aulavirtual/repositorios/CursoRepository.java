package com.app.aulavirtual.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.aulavirtual.entidades.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT DISTINCT c FROM Curso c"
    + " LEFT JOIN c.estudiantes e"
    + " LEFT JOIN c.profesor p"
    + " WHERE e.persona.usuario.username = :usuario OR p.persona.usuario.username = :usuario")
    List<Curso> listarCursosPorUsuario(@Param("usuario") String usuario);

}
