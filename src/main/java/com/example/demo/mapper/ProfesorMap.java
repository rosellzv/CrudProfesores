package com.example.demo.mapper;
import com.example.demo.persistence.entity.profesor;
import com.example.demo.service.Dto;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMap implements IMapper<Dto, profesor>{

    @Override
    public profesor map(Dto in) {
        profesor profesor = new profesor();
        profesor.setNombre(in.getNombre());
        profesor.setApellido(in.getApellido());
        profesor.setAsignatura(in.getAsignatura());
        profesor.setUniversidad(in.getUniversidad());
        return profesor;
    }
}
