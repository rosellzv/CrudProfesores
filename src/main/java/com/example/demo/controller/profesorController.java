package com.example.demo.controller;

import com.example.demo.persistence.entity.profesor;
import com.example.demo.service.Dto;
import com.example.demo.service.ProfesorService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = "http://localhost:4200/")
public class profesorController {

    private final ProfesorService profesorService;
    public String message;

    public profesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public profesor addProfesor( @RequestBody Dto dto){
      return this.profesorService.AdicionarProfesores(dto);
    }

    @GetMapping("/message")
    public String envioConfirmacion(){
        return message;
    }

    @GetMapping
    public ResponseEntity <List<profesor>> findAll(){
        List<profesor> profe = profesorService.findAll();
        if(profe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<profesor> eliminarProfesor(@PathVariable("id") Long id){
        profesor profe = this.profesorService.findxid(id);
        if(null == profe){
            return ResponseEntity.noContent().build();
        }
        this.profesorService.eliminarProfesor(id);
        return ResponseEntity.ok(profe);
    }
    @GetMapping("/{id}")
    public ResponseEntity<profesor> findxid(@PathVariable("id") Long id){
        profesor profe = this.profesorService.findxid(id);
        return ResponseEntity.ok(profe);
    }

    @PutMapping("/{id}")
    public void modificar(@RequestBody Dto dto, @PathVariable("id") Long id){
        this.profesorService.modificarProfesor(dto,id);
    }
}
