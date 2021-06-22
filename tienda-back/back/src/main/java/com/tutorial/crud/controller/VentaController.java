package com.tutorial.crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Venta;
import com.tutorial.crud.service.UsuarioService;
import com.tutorial.crud.service.VentaService;

@RestController
@RequestMapping("/api/venta")
//@CrossOrigin(origins = "*")
public class VentaController {
	@Autowired
	VentaService ventaService;
	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<Venta>> list(){
        List<Venta> list = ventaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Venta> getById(@PathVariable("id") int id){
        if(!ventaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        return new ResponseEntity(ventaService.getOne(id).get(), HttpStatus.OK);
    }

    @GetMapping("/detailByUsuario/{correo}")
    public ResponseEntity<Venta> getByNombre(@PathVariable("correo") String correo){
    	 usuarioService.encontrarPorCorreo(correo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No existe usuario con correo %s", correo)));;	 				
        return new ResponseEntity(ventaService.getVentaByCorreo(correo).get(), HttpStatus.OK);
    }
    
   
}
