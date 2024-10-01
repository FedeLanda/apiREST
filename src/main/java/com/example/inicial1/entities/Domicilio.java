package com.example.inicial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
@Table(name = "domicilio")
public class Domicilio extends Base{

    private String calle;
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;

}
