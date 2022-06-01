package com.example.demo.service;

import com.example.demo.persistence.entity.profesor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter @Getter
@Builder
public class Dto extends profesor {
    private String nombre;

    private String apellido;

    private String asignatura;

    private String universidad;

    private Integer edad;


}
