package com.itzamara.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Catalogo;
import com.itzamara.crud.entity.Rol;
import com.itzamara.crud.repository.CatalogoRepository;

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
