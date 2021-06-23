package com.itzamara.crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Carrito;
import com.itzamara.crud.entity.Producto;
import com.itzamara.crud.entity.Usuario;
import com.itzamara.crud.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }
	
	public Optional<Usuario> encontrarPorCorreo(String correo) {
		Optional<Usuario> temp = usuarioRepository.findByCorreo(correo);
//		log.info("Buscando usuario con correo : {}", temp.get().getRol().getNombre());
		return usuarioRepository.findByCorreo(correo);
	}
	
	 public void  save(Usuario u){
	    	usuarioRepository.save(u);
	    }

	    public void delete(int id){
	    	usuarioRepository.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return usuarioRepository.existsById(id);
	    }
	    
	   
}
