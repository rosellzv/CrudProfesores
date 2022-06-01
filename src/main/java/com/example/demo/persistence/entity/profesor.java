package com.example.demo.persistence.entity;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "profesor")
@Getter @Setter
@Data


public class profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min =2, message = "El nombre debe tener 2 o mas caracteres")
    private String nombre;
    @NotNull
    @Size(min = 2,message = "El campo apellido debe tener mas de 2 caracteres")
    private String apellido;
    @NotNull
    @Size(min=2, message = "El nombre de la asignatura debe tener 2 o mas caracteres")
    private String asignatura;
    @NotNull
    @Size(min = 2,message = "El nombre de la universidad debe tener 2 o mas caracteres")
    private String universidad;
    @NotNull

    private Integer edad;


}
