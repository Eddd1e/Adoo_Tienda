package com.itzamara.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Producto;
import com.itzamara.crud.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> list(){
        return productoRepository.findAll();
    }
    public List<Producto> findAllProductoByIdCatalogo(int id){
    	return productoRepository.findAllProductoByIdCatalogo(id);
    }

    public Optional<Producto> getOne(int id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> getByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public void  save(Producto producto){
        productoRepository.save(producto);
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }
    
    public boolean actualizarCantidad(Producto p, int cantidad) {
    	if(p.getCantidad()-cantidad >= 0 ) {
    		p.setCantidad(p.getCantidad()-cantidad);
    		productoRepository.save(p);
    		return true;
    	}
    	return false;
    }

    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }
}
