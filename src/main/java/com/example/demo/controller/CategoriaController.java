package com.example.demo.controller;

import com.example.demo.persistence.entity.CategoriaDocente;
import com.example.demo.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDocente>> listarCategorias(){
        List<CategoriaDocente> categoriaDocenteList = categoriaService.ListarCategorias();
        if(categoriaDocenteList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoriaDocenteList);
    }

    @PostMapping
    public ResponseEntity adicionarCategorias(@RequestBody CategoriaDocente categoriaDocente){
        if(null == categoriaDocente){
            return ResponseEntity.ok("No se pudo adicionar la categoria");
        }
        categoriaService.addCategoria(categoriaDocente);
        return ResponseEntity.ok("Se adiciono correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDocente> buscarCategoria(@PathVariable Long id){
        CategoriaDocente cat = categoriaService.buscarCategoria(id);
        if(null == cat){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(cat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCategoria(@PathVariable Long id){
        CategoriaDocente cat = categoriaService.buscarCategoria(id);
        if(null == cat){
            return ResponseEntity.ok("No existe la categoria");
        }
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok("La categoria se elimino con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity modificarCategoria(@RequestBody CategoriaDocente cat){
        CategoriaDocente categoriaDocente = categoriaService.buscarCategoria(cat.getIdCategoria());
        if(null == categoriaDocente){
            return ResponseEntity.ok("No existe la categoria");
        }
        categoriaDocente.setNombreCategoria(cat.getNombreCategoria());
        categoriaService.modificarCategoria(categoriaDocente);
        return ResponseEntity.ok("Se modifico la categoria correctamente!!");
    }

}
