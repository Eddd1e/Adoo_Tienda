package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.Usuario;
import com.tutorial.crud.repository.UsuarioRepository;

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
		log.info("Buscando usuario con correo : {}", temp.get().getRol().getNombre());
		return usuarioRepository.findByCorreo(correo);
	}
}
