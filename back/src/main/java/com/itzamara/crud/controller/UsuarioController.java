package com.itzamara.crud.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.itzamara.crud.dto.CarritoDto;
import com.itzamara.crud.dto.Mensaje;
import com.itzamara.crud.dto.PagoDto;
import com.itzamara.crud.dto.UsuarioDto;
import com.itzamara.crud.entity.Carrito;
import com.itzamara.crud.entity.MetodoPago;
import com.itzamara.crud.entity.Pago;
import com.itzamara.crud.entity.Producto;
import com.itzamara.crud.entity.Usuario;
import com.itzamara.crud.entity.Venta;
import com.itzamara.crud.entity.VentaProducto;
import com.itzamara.crud.repository.ProductoRepository;
import com.itzamara.crud.service.CarritoService;
import com.itzamara.crud.service.ProductoService;
import com.itzamara.crud.service.RolService;
import com.itzamara.crud.service.UsuarioService;
import com.itzamara.crud.service.VentaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CarritoService carritoService;
	@Autowired
	RolService rolservice;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
    ProductoService productoService;
	
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
	
	@GetMapping("/usuario/carrito{correo}")
    public ResponseEntity<List<Carrito>> getCarritoUsuario(@RequestParam("correo") String correo){
        Optional<Usuario> r = usuarioService.encontrarPorCorreo(correo);
        if(r.isEmpty()) {
        	return new ResponseEntity(new Mensaje("Usuario no existe"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(r.get().getCarrito(), HttpStatus.OK);
    }
	
	  @PostMapping("usuario/create")
	    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
		 
		  	List<Carrito> carritos = carritoService.findByCorreo(usuarioDto.getCorreo());
		 
		    Usuario u = new Usuario(usuarioDto.getCorreo(),usuarioDto.getPassword(),usuarioDto.getNombre(),usuarioDto.getTelefono(), usuarioDto.getClienteFrecuente(),carritos,rolservice.getOne(usuarioDto.getId_rol()).get());
		    u.setCarrito(new ArrayList<Carrito>());
		    usuarioService.save(u);
	    	return new ResponseEntity(new Mensaje("usuario creado"), HttpStatus.OK);
	   }
	  
	  @PutMapping("usuario/carrito/{correo}")
	  public ResponseEntity<?> agregarAlCarrito(@RequestParam("correo") String correo, @RequestBody CarritoDto carritoDto){
			 
		  	Usuario r = usuarioService.encontrarPorCorreo(correo).get();
		  	List<Carrito> c = r.getCarrito();
		  	Producto stock  = productoService.getOne(carritoDto.getP().getId()).get();
		  	if (productoService.actualizarCantidad(stock , carritoDto.getCantidad())) {
		  		c.add(new Carrito(carritoDto.getP(), r, carritoDto.getCantidad()));
			    r.setCarrito(c);
		    	return new ResponseEntity(new Mensaje("item agregado"), HttpStatus.OK);
		  	}else {
		  		return new ResponseEntity(new Mensaje("no hay suficientes productos en stock"), HttpStatus.BAD_REQUEST);
		  	}
		  	
	   }
	  
	
	  
}
