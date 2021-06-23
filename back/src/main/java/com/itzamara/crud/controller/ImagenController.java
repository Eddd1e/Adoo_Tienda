package com.itzamara.crud.controller;

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

import com.itzamara.crud.dto.ImagenDto;
import com.itzamara.crud.dto.Mensaje;
import com.itzamara.crud.dto.ProductoDto;
import com.itzamara.crud.entity.Imagen;
import com.itzamara.crud.service.ImagenService;
import com.itzamara.crud.service.ProductoService;

@RestController
@RequestMapping("/api/imagen")
public class ImagenController {
	
	@Autowired
    ImagenService imagenService;
	
	@Autowired
    ProductoService productoService;
	
//	@GetMapping("/lista/{idProducto}")
//    public ResponseEntity<List<Imagen>> listByProducto(@PathVariable("idProducto") int idProducto){
//		
//		List<Imagen> lista = imagenService.getImagenesById(idProducto);
//		return new ResponseEntity(lista, HttpStatus.OK);
//		
//	}
//	
//	@PostMapping("/upload")
//    public ResponseEntity<?> subirImagenes(@RequestBody ImagenDto imagenDto ){
//		
//		Imagen i = new Imagen();
//		i.setImagen(imagenDto.getImagen());
//		i.setProducto(productoService.getOne(imagenDto.getIdProducto()));
//		imagenService.save(i);
//		return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
//		
//	}
	
}
