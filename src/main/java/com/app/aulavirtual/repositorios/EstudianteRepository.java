package com.app.aulavirtual.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aulavirtual.entidades.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
