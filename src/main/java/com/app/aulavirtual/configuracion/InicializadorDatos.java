package com.app.aulavirtual.configuracion;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.app.aulavirtual.entidades.*;
import com.app.aulavirtual.repositorios.*;

@Configuration
public class InicializadorDatos {

    @Bean
    CommandLineRunner inicializarBaseDatos (
        UserRepository userRepository,
        PersonaRepository personaRepository,
        EstudianteRepository estuRepository,
        ProfesorRepository profeRepository,
        CursoRepository cursoRepository,
        PasswordEncoder passwordEncoder,
        RolRepository rolRepository
    ) {
        return arg -> {
            
            if (userRepository.findByUsername("cdzapata").isEmpty()) {

                var rolAdmin = rolRepository.findByNombre("ADMIN").orElseGet(
                    () -> rolRepository.save(new Rol(null,"ADMIN", null))
                );
                var rolEstu = rolRepository.findByNombre("ESTUDIANTE").orElseGet(
                    () -> rolRepository.save(new Rol(null,"ESTUDIANTE", null))
                );
                var rolProfe = rolRepository.findByNombre("PROFESOR").orElseGet(
                    () -> rolRepository.save(new Rol(null,"PROFESOR", null))
                );

                // Personas

                var adminPerson = new Persona(null, "Cristian","Zapata", "1111", null);
                adminPerson = personaRepository.save(adminPerson);

                var estuPerson = new Persona(null, "Estudiante", "Uno", "2222", null);
                estuPerson = personaRepository.save(estuPerson);

                var profePerson = new Persona(null, "Profesor", "Uno", "3333", null);
                profePerson = personaRepository.save(profePerson);

                // Usuarios

                var adminUser = new User (
                    null, "cdzapata", passwordEncoder.encode("12345"),
                    List.of(rolAdmin), adminPerson
                );
                userRepository.save(adminUser);

                var estuUser = new User (
                    null, "estudiante1", passwordEncoder.encode("12345"),
                    List.of(rolEstu), estuPerson
                );
                userRepository.save(estuUser);

                var profeUser = new User (
                    null, "profesor1", passwordEncoder.encode("12345"),
                    List.of(rolProfe), profePerson
                );
                userRepository.save(profeUser);

                // Cursos

                var profe = new Profesor (
                    null, profePerson, null
                );
                profeRepository.save(profe);

                var curso1 = new Curso (
                    null,
                    "CursoUno",
                    "CURSO1",
                    null,
                    profe
                );
                cursoRepository.save(curso1);
                var curso2 = new Curso (
                    null,
                    "CursoDos",
                    "CURSO2",
                    null,
                    profe
                );
                cursoRepository.save(curso2);

                
                

                var estu = new Estudiante (
                    null, 941323.0, estuPerson, List.of(curso1)
                );
                estuRepository.save(estu);
            }
        };
    }
}
