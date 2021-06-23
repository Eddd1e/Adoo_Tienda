package com.itzamara.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itzamara.crud.entity.Venta;
import com.itzamara.crud.entity.VentaProducto;
import com.itzamara.crud.repository.VentaProductoRepository;


@Service
@Transactional
public class VentaProductoService {

    @Autowired
    VentaProductoRepository ventaProductoRepository;

    public List<VentaProducto> list(){
        return ventaProductoRepository.findAll();
    }
   

    public void  save(VentaProducto producto){
    	ventaProductoRepository.save(producto);
    }


  
}