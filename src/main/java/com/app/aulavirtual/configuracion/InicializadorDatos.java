package com.app.aulavirtual.configuracion;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.aulavirtual.entidades.Persona;
import com.app.aulavirtual.entidades.Rol;
import com.app.aulavirtual.entidades.User;
import com.app.aulavirtual.repositorios.PersonaRepository;
import com.app.aulavirtual.repositorios.RolRepository;
import com.app.aulavirtual.repositorios.UserRepository;

@Configuration
public class InicializadorDatos {

    @Bean
    CommandLineRunner inicializarBaseDatos(
            UserRepository usuRepository,
            PasswordEncoder passwordEncoder,
            PersonaRepository personaRepository,
            RolRepository rolRepository
        ) {

        return arg -> {
            
            if (usuRepository.findByUsername("cdzapata").isEmpty()) {

                Rol rolAdmin = rolRepository.findByNombre("ADMIN").orElseGet(
                    () -> rolRepository.save(new Rol(null,"ADMIN", null))
                );

                Persona persona = new Persona(null, "Cristian","Zapata", "1111", null);
                persona = personaRepository.save(persona);

                User user = new User(null, "cdzapata"
                , passwordEncoder.encode("12345"), List.of(rolAdmin), persona);
                usuRepository.save(user);
            }
        };
    }
}
