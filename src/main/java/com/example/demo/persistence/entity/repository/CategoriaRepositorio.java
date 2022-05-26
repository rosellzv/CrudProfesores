package com.example.demo.persistence.entity.repository;

import com.example.demo.persistence.entity.CategoriaDocente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<CategoriaDocente, Long> {
}
