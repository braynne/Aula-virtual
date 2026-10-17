package com.app.aulavirtual.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aulavirtual.entidades.MensajeForo;

public interface MensajeForoRepository extends JpaRepository<MensajeForo, Long> {
    List<MensajeForo> findByCursoIdOrderByFechaAsc(Long cursoId);
}