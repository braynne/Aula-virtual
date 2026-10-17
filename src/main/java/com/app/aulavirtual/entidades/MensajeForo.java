package com.app.aulavirtual.entidades;

import java.time.OffsetDateTime;
import lombok.*;
import jakarta.persistence.*;

@Entity @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor 
@Table(name = "mensaje_foro")
public class MensajeForo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curso_id")
    private Long cursoId;

    @Column
    private String texto;

    @Column
    private OffsetDateTime fecha;

    @Column 
    private String autor;

}
