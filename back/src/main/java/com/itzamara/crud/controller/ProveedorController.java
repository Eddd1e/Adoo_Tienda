package com.itzamara.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.itzamara.crud.dto.Mensaje;
import com.itzamara.crud.dto.PagoDto;
import com.itzamara.crud.dto.ProveedorDto;
import com.itzamara.crud.entity.MetodoPago;
import com.itzamara.crud.entity.Pago;
import com.itzamara.crud.entity.Proveedor;
import com.itzamara.crud.entity.Usuario;
import com.itzamara.crud.entity.Venta;
import com.itzamara.crud.repository.ProveedorRepository;
import com.itzamara.crud.service.ProveedorService;
import com.itzamara.crud.service.UsuarioService;

@RestController
@RequestMapping("/api/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController {
	@Autowired
	ProveedorService proveedorService;
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/lista")
	public ResponseEntity<List<Proveedor>> list() {
		return new ResponseEntity(proveedorService.list(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> getById(@PathVariable("id") int id) {
		return new ResponseEntity(proveedorService.getOne(id).get(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProveedorDto proveedorDto) {
	
		proveedorService.save(new Proveedor(proveedorDto.getNombre(), proveedorDto.getTelefono(),proveedorDto.getDireccion(), proveedorDto.getCorreo()));
		return new ResponseEntity(new Mensaje("proveedor creado"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!proveedorService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		proveedorService.delete(id);
		return new ResponseEntity(new Mensaje("proveedorService eliminado"), HttpStatus.OK);
	}

}
