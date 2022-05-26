package com.example.demo.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categoriaDocente")
@Data
public class CategoriaDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long idCategoria;

    @Getter @Setter
    private String nombreCategoria;

}
