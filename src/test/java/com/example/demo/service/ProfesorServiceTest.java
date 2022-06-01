package com.example.demo.service;

import com.example.demo.mapper.IMapper;
import com.example.demo.mapper.ProfesorMap;
import com.example.demo.persistence.entity.CategoriaDocente;
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
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
class ProfesorServiceTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private Dto dto;
    @Mock
    private ProfesorMap mapper;

    @InjectMocks
    private ProfesorService profesorService;

    private profesor profesorDatos;
    private profesor profe;
    private Dto dtoProfesor;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

         dtoProfesor = Dto.builder()
                .nombre("Rosell")
                .apellido("Zayas")
                .asignatura("Informatica")
                .universidad("UCI")
                .edad(35)
                .build();


        profesorDatos = new profesor();
        profesorDatos.setId(1L);
        profesorDatos.setNombre("Rosell");
        profesorDatos.setApellido("Zayas");
        profesorDatos.setAsignatura("Informatica");
        profesorDatos.setUniversidad("UCI");
        profesorDatos.setEdad(33);
    }

    @DisplayName("Verifica el ingreso de un profesor")
    @Test
    void adicionarProfesores() {
        when(profesorRepository.save(any(profesor.class))).thenReturn(profe);
        //profe profe1 = mapper.map(dtoProfesor);
        Assertions.assertNotNull(profesorService.AdicionarProfesores(dtoProfesor));
    }

    @Test
    void findAll() {
        when(profesorRepository.findAll()).thenReturn(Arrays.asList(profe));
        Assertions.assertNotNull(profesorService.findAll());
    }

    @Test
    void eliminarProfesor() {
    }

    @DisplayName("verifica que se busque por un id que no exista")
    @Test
    void findxid() {
        when(profesorRepository.findById(profe.getId())).thenReturn(null);
        assertEquals(null,profesorService.findxid(5L));
    }

    @Test
    void modificarProfesor() {
           when(profesorRepository.save(any(profesor.class))).thenReturn(profe);
           assertNotNull(profesorService.modificarProfesor(dtoProfesor,1L));
    }
}