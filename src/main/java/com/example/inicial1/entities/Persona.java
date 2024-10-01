package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
@Table(name="persona")
public class Persona extends Base{

    private String nombre;
    private String apellido;

    private int dni;

    @OneToOne(cascade = CascadeType.ALL)//persistencia actualizacion y eliminacion
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @Builder.Default
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinTable(
            name="persona_libro",
            joinColumns=@JoinColumn(name="persona_id"),
            inverseJoinColumns = @JoinColumn(name="libro_id")
    )
    private List<Libro> libros= new ArrayList<Libro>();


}

