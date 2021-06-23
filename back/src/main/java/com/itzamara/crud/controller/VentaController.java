package com.itzamara.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.itzamara.crud.dto.Mensaje;
import com.itzamara.crud.dto.VentaDto;
import com.itzamara.crud.entity.Producto;
import com.itzamara.crud.entity.Usuario;
import com.itzamara.crud.entity.Venta;
import com.itzamara.crud.repository.VentaProductoRepository;
import com.itzamara.crud.service.ProductoService;
import com.itzamara.crud.service.UsuarioService;
import com.itzamara.crud.service.VentaService;

@RestController
@RequestMapping("/api/venta")
@CrossOrigin(origins = "*")
public class VentaController {
	@Autowired
	VentaService ventaService;
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoService;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	@GetMapping("/lista")
    public ResponseEntity<List<Venta>> list(){
        List<Venta> list = ventaService.list();
        List<Venta> list2 = ventaService.getVentaByCorreo("cliente@gmail.com");
        log.info("infoinfo {}",list2.size());
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/lista/{correo}")
    public ResponseEntity<List<Venta>> listCorreo(@PathVariable("correo") String correo){
        List<Venta> list2 = ventaService.getVentaByCorreo("cliente@gmail.com");
        return new ResponseEntity(list2, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Venta> getById(@PathVariable("id") int id){
        if(!ventaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        return new ResponseEntity(ventaService.getOne(id).get(), HttpStatus.OK);
    }
    
    @PostMapping("/create/{correo}")
    public ResponseEntity<?> createVenta(@RequestBody VentaDto ventaDto, @PathVariable("correo") String correo){
    	Venta v = new Venta();
    	v.setFecha(ventaDto.getFecha());
    	v.setPagado(ventaDto.getPagado());
    	v.setDeuda(ventaDto.getDeuda());
    	List<Producto> p = new ArrayList<Producto>();
    	Usuario u = usuarioService.encontrarPorCorreo(correo).get();
    	int a[] = ventaDto.getProductos();
    	for (int i = 0; i<a.length; i++) {
    		p.add(productoService.getOne(a[i]).get());
    	}
    	v.setUsuario(u);
    	ventaService.save(v);
		return new  ResponseEntity(new Mensaje("compra creada"), HttpStatus.OK);
   }
    
   
}
