package com.itzamara.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.itzamara.crud.dto.Mensaje;
import com.itzamara.crud.dto.ProductoDto;
import com.itzamara.crud.entity.Catalogo;
import com.itzamara.crud.entity.Imagen;
import com.itzamara.crud.entity.Producto;
import com.itzamara.crud.entity.Proveedor;
import com.itzamara.crud.service.CatalogoService;
import com.itzamara.crud.service.ImagenService;
import com.itzamara.crud.service.ProductoService;
import com.itzamara.crud.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {


    @Autowired
    ProductoService productoService;
    
    @Autowired
    CatalogoService catalogoService;
    
    @Autowired
    ImagenService imagenService;
    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){
        List<Producto> list = productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/lista/catalogo/{id}")
    public ResponseEntity<List<Producto>> listaProductoByIdCatalogo(@PathVariable("id") int idCatalogo){
    	List<Producto> list = productoService.findAllProductoByIdCatalogo(idCatalogo);
    	return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        if(!productoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getByNombre(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(!catalogoService.existsById(productoDto.getId_catalogo()))
            return new ResponseEntity(new Mensaje("ese catalogo no existe"), HttpStatus.BAD_REQUEST);
        if(!proveedorService.existsById(productoDto.getId_proveedor()))
            return new ResponseEntity(new Mensaje("ese proveedor no existe"), HttpStatus.BAD_REQUEST);
       //TODO registrar la imagen y no jalar una ya existente
        
        //( Proveedor proveedor, Catalogo catalogo, String nombre, int cantidad, float precio,
		//String descripcion, List<Imagen> imagenes)
        
        Producto producto = new Producto(proveedorService.getOne(productoDto.getId_proveedor()).get(),
				catalogoService.getOne(productoDto.getId_catalogo()).get(), productoDto.getNombre(),
				productoDto.getCantidad(), productoDto.getPrecio(), productoDto.getDescripcion());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.getOne(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setId_proveedor(proveedorService.getOne(productoDto.getId_proveedor()).get());
        producto.setCatalogo(catalogoService.getOne(productoDto.getId_catalogo()).get());
        producto.setCantidad(productoDto.getCantidad());
    //    producto.setImagenes(imagenService.getImagenesById(id));
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


}
