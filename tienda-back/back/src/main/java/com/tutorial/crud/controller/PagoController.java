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
import com.tutorial.crud.entity.Pago;

import com.tutorial.crud.service.PagoService;
import com.tutorial.crud.service.UsuarioService;
import com.tutorial.crud.service.VentaService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	@Autowired
	VentaService ventaService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	PagoService pagoService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Pago>> list(){
        return new ResponseEntity(pagoService.list(), HttpStatus.OK);
    }
	
	 @GetMapping("/pagosByIdVenta/{id}")
	    public ResponseEntity<Pago> getById(@PathVariable("id") int id){
	        if(!ventaService.existsById(id))
	            return new ResponseEntity(new Mensaje("venta no existe"), HttpStatus.NOT_FOUND);
	        
	        return new ResponseEntity(pagoService.findByIdVenta(id), HttpStatus.OK);
	    }

	    @GetMapping("/pagosByUsuario/{correo}")
	    public ResponseEntity<Pago> getByNombre(@PathVariable("correo") String correo){
	    	 usuarioService.encontrarPorCorreo(correo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No existe usuario con correo %s", correo)));;	 				
	        return new ResponseEntity(pagoService.findAllByCorreo(correo), HttpStatus.OK);
	    }
}
