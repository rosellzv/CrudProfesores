package com.example.demo.service;


import com.example.demo.mapper.ProfesorMap;
import com.example.demo.persistence.entity.profesor;
import com.example.demo.persistence.entity.repository.ProfesorRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        profesor profe1 = mapper.map(dto);
        return this.repository.save(profe1);
    }

    public List<profesor> findAll(){
        return this.repository.findAll();
    }

    public profesor eliminarProfesor(long id) {
        profesor profe = findxid(id);
        if(null == profe){
            return null;
        }
        this.repository.deleteById(id);
        return null;
    }


    public profesor findxid(long id){
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public profesor modificarProfesor(Dto dto,Long id){
        profesor profesor1 = mapper.map(dto);
        profesor profe = findxid(id);
        if(null == profe){
            return null;
        }
        profe.setNombre(profesor1.getNombre());
        profe.setApellido(profesor1.getApellido());
        profe.setAsignatura(profesor1.getAsignatura());
        profe.setUniversidad(profesor1.getUniversidad());

        return repository.save(profe);
    }



}
