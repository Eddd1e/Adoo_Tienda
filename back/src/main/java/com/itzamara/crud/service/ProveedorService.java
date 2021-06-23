package com.itzamara.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Proveedor;
import com.itzamara.crud.repository.ProveedorRepository;


@Service
@Transactional
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> list(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getOne(int id){
        return proveedorRepository.findById(id);
    }

    public Optional<Proveedor> getByNombre(String nombre){
        return proveedorRepository.findByNombre(nombre);
    }

    public void  save(Proveedor r){
    	proveedorRepository.save(r);
    }

    public void delete(int id){
    	proveedorRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return proveedorRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return proveedorRepository.existsByNombre(nombre);
    }
}