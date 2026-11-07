package com.app.aulavirtual.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aulavirtual.entidades.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByNombre(String rol);
}
