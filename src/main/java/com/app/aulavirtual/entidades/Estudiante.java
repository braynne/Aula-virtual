package com.app.aulavirtual.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private Double codigo;

    @OneToOne(optional = false)
    @JoinColumn(name = "persona_id", nullable = false, unique = true)
    private Persona persona;
    
    @ManyToMany 
    @JoinTable(name = "estudiante_curso", 
    joinColumns =  @JoinColumn (name = "estudiante_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

}
