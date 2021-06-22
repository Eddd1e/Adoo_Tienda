package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Catalogo;
import com.tutorial.crud.repository.CatalogoRepository;

@Service
@Transactional
public class CatalogoService {

    @Autowired
    CatalogoRepository catalogoRepository;

    public List<Catalogo> list(){
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> getOne(int id){
        return catalogoRepository.findById(id);
    }

    public Optional<Catalogo> getByNombre(String nombre){
        return catalogoRepository.findByNombre(nombre);
    }

    public void  save(Catalogo producto){
    	catalogoRepository.save(producto);
    }

    public void delete(int id){
    	catalogoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return catalogoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return catalogoRepository.existsByNombre(nombre);
    }
}
