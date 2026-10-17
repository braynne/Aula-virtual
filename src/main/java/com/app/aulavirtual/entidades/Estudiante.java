package com.app.aulavirtual.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Estudiante extends Persona {

    @Column(name = "codigo")
    private Double codigo;

    @ManyToMany 
    @JoinTable(name = "estudiante_curso", 
    joinColumns =  @JoinColumn (name = "estudiante_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

}
