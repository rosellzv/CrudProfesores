package com.example.demo.service;

import com.example.demo.mapper.IMapper;
import com.example.demo.persistence.entity.profesor;
import com.example.demo.persistence.entity.repository.ProfesorRepository;
import org.apache.catalina.mapper.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.apache.catalina.mapper.Mapper.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProfesorServiceTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private IMapper mapper;

    @InjectMocks
    private ProfesorService profesorService;

    private profesor profesor;
    private Dto dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        profesor = new profesor();
        dto = new Dto();

        profesor.setId(1L);
        dto.setNombre("Rosell");
        dto.setApellido("Zayas");
        dto.setAsignatura("Informatica");
        dto.setUniversidad("UCI");


    }

    @DisplayName("Verifica el ingreso de un profesor")
    @Test
    void adicionarProfesores() {

    }

    @Test
    void findAll() {
        when(profesorRepository.findAll()).thenReturn(Arrays.asList(profesor));
        Assertions.assertNotNull(profesorService.findAll());
    }

    @Test
    void eliminarProfesor() {
    }

    @DisplayName("")
    @Test
    void findxid() {
        when(profesorRepository.findById(profesor.getId())).thenReturn(null);
        assertEquals(null,profesorService.findxid(5L));
    }

    @Test
    void modificarProfesor() {
    }
}