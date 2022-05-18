package com.example.demo.service;


import com.example.demo.mapper.ProfesorMap;
import com.example.demo.persistence.entity.profesor;
import com.example.demo.persistence.entity.repository.ProfesorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfesorService {

    private final ProfesorRepository repository;
    private final ProfesorMap mapper;

    public ProfesorService(ProfesorRepository repository, ProfesorMap mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public profesor AdicionarProfesores(Dto dto){
        profesor profe = mapper.map(dto);
        return this.repository.save(profe);
    }

    public List<profesor> findAll(){
        return this.repository.findAll();
    }

    public void eliminarProfesor(long id) {
        this.repository.deleteById(id);
    }


    public Optional<profesor> findxid(long id){
        return this.repository.findById(id);
    }




}
