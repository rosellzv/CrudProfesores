package com.example.demo.service;

import com.example.demo.persistence.entity.CategoriaDocente;
import com.example.demo.persistence.entity.repository.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepositorio categoriaRepositorio;

    public CategoriaService(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public List<CategoriaDocente> ListarCategorias(){
        return this.categoriaRepositorio.findAll();
    }

    public CategoriaDocente addCategoria(CategoriaDocente categoria){
        return this.categoriaRepositorio.save(categoria);
    }

    public CategoriaDocente buscarCategoria(Long id){
        return this.categoriaRepositorio.findById(id).orElse(null);
    }
    public CategoriaDocente eliminarCategoria(Long id){
        CategoriaDocente categoria = buscarCategoria(id);
        if(null == categoria){
            return null;
        }
        categoriaRepositorio.delete(categoria);
        return null;
    }

    public CategoriaDocente modificarCategoria(CategoriaDocente categoria){
        CategoriaDocente cat = buscarCategoria(categoria.getIdCategoria());
        if(null == cat){
            return null;
        }
        cat.setNombreCategoria(categoria.getNombreCategoria());
       return categoriaRepositorio.save(cat);
    }
}
