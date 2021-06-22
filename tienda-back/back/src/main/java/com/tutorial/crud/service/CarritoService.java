package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Carrito;
import com.tutorial.crud.entity.Catalogo;
import com.tutorial.crud.repository.CarritoRepository;

@Service
@Transactional
public class CarritoService {
	
	 @Autowired
	CarritoRepository carritoService;
	 

	    public List<Carrito> list(){
	        return carritoService.findAll();
	    }

	    public Optional<Carrito> getOne(int id){
	        return carritoService.findById(id);
	    }
	    
	    public void  save(Carrito producto){
	    	carritoService.save(producto);
	    }

	    public void delete(int id){
	    	carritoService.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return carritoService.existsById(id);
	    }
	    
	    public List<Carrito> findByCorreo(String c){
	    	return carritoService.findByCorreo(c);
	    }
	   
}
