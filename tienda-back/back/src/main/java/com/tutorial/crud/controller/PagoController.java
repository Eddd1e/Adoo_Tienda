package com.tutorial.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.PagoDto;
import com.tutorial.crud.entity.MetodoPago;
import com.tutorial.crud.entity.Pago;
import com.tutorial.crud.entity.Usuario;
import com.tutorial.crud.entity.Venta;
import com.tutorial.crud.service.MetodoPagoService;
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
	@Autowired
	MetodoPagoService metodoPagoService;
	
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
	    
	    
	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody PagoDto pagoDto){
	    Usuario u = usuarioService.encontrarPorCorreo(pagoDto.getCorreo()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No existe usuario con correo %s", pagoDto.getCorreo())));;	 				
	    Venta v = ventaService.getOne(pagoDto.getId_venta()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Venta No existe%s", pagoDto.getId_venta())));;	 				
	    MetodoPago m = metodoPagoService.getOne(pagoDto.getId_metodo()).get();
	    ventaService.UpdateDeudaVenta(pagoDto.getCantidad(),pagoDto.getId_venta());
	    pagoService.save(new Pago(u,m,v,pagoDto.getCantidad()));
	    	return new ResponseEntity(new Mensaje("Pago creado"), HttpStatus.OK);
	    }
}
