package com.example.demo.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Dto {
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String asignatura;

    @Getter @Setter
    private String universidad;
}
