package com.example.demo.service;

import com.example.demo.persistence.entity.CategoriaDocente;
import com.example.demo.persistence.entity.repository.CategoriaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

class CategoriaServiceTest {

    @Mock
    private CategoriaRepositorio categoriaRepositorio;

    @InjectMocks
    private CategoriaService categoriaService;

    private CategoriaDocente categoriaDocente;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        categoriaDocente = new CategoriaDocente();
        categoriaDocente.setIdCategoria(1L);
        categoriaDocente.setNombreCategoria("docente");

    }

    @DisplayName("Verifica que se listen los datos")
    @Test
    void listarCategorias() {
        when(categoriaRepositorio.findAll()).thenReturn(Arrays.asList(categoriaDocente));
        assertNotNull(categoriaService.ListarCategorias());
    }

    @DisplayName("Verifica que se adicionan los datos")
    @Test
    void addCategoria() {
        when(categoriaRepositorio.save(any(CategoriaDocente.class))).thenReturn(categoriaDocente);
        assertNotNull(categoriaService.addCategoria(new CategoriaDocente()));
    }

    @DisplayName("Metodo para verificar que modifica correctamente los datos")
    @Test
    void modificarCategoria() {
        when(categoriaRepositorio.save(any(CategoriaDocente.class))).thenReturn(categoriaDocente);
        assertNotNull(categoriaService.addCategoria(new CategoriaDocente()));
    }

    @DisplayName("verificar que lanza null en caso de que el id de la categoria no existe")
    @Test
    void busquedaXIdIncorrecto(){
        when(categoriaRepositorio.findById(categoriaDocente.getIdCategoria())).thenReturn(null);
        assertEquals(null,categoriaService.buscarCategoria(5L));
    }

    @DisplayName("Verificar Que la busqueda por id me devuelva una categoria")
    @Test
    void busquedaXIdCorrecta(){
        when(categoriaRepositorio.findById(categoriaDocente.getIdCategoria())).thenReturn(notNull());
        assertNotNull(categoriaService.buscarCategoria(1L));
    }


}