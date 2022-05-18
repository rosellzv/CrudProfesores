package com.example.demo.controller;

import com.example.demo.persistence.entity.profesor;
import com.example.demo.service.Dto;
import com.example.demo.service.ProfesorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class profesorController {

    private final ProfesorService profesorService;

    public profesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public profesor addProfesor(@RequestBody Dto dto){
       return this.profesorService.AdicionarProfesores(dto);
    }

    @GetMapping
    public List<profesor> findAll(){
        return this.profesorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(Long id){
        this.profesorService.eliminarProfesor(id);
    }


    @GetMapping("/profesor/{id}")
    public Optional<profesor> findxid(@PathVariable("id") Long id){
        return this.profesorService.findxid(id);
    }

}
