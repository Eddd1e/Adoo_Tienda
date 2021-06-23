package com.itzamara.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Carrito;
import com.itzamara.crud.entity.Catalogo;
import com.itzamara.crud.repository.CarritoRepository;

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
