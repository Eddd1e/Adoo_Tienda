package com.tutorial.crud.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.Usuario;
import com.tutorial.crud.service.UsuarioService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> list = usuarioService.lista();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/usuario{correo}")
    public ResponseEntity<List<Usuario>> getUsuarioByEmail(@RequestParam("correo") String correo){
        Optional<Usuario> r = usuarioService.encontrarPorCorreo(correo);
        if(r.isEmpty()) {
        	return new ResponseEntity(new Mensaje("Usuario no existe"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(r.get(), HttpStatus.OK);
    }
}
