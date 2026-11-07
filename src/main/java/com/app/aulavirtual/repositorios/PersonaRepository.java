package com.app.aulavirtual.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aulavirtual.entidades.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
