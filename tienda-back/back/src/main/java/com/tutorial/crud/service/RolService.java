package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Catalogo;
import com.tutorial.crud.entity.Rol;
import com.tutorial.crud.repository.CatalogoRepository;

@Service
@Transactional
public class RolService {
	 @Autowired
	 RolRepository rolRepository;

	    public List<Rol> lista(){
	        return rolRepository.findAll();
	    }

	    public Optional<Rol> getOne(int id){
	        return rolRepository.findById(id);
	    }

	    public void  save(Rol producto){
	    	rolRepository.save(producto);
	    }

	    public void delete(int id){
	    	rolRepository.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return rolRepository.existsById(id);
	    }

	   
}
