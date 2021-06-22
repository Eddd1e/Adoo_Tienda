package com.tutorial.crud.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.Venta;
import com.tutorial.crud.repository.VentaRepository;

@Service
@Transactional
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    public List<Venta> list(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> getOne(int id){
        return ventaRepository.findById(id);
    }

    public void  save(Venta producto){
    	ventaRepository.save(producto);
    }

    public void delete(int id){
    	ventaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return ventaRepository.existsById(id);
    }
    
    public Optional<Venta> getVentaByCorreo(String correo){	
        return ventaRepository.findByCorreo(correo);
    }
    
    public void UpdateDeudaVenta(BigDecimal cantidadDeuda, int idVenta) {
    	
    	Venta v = ventaRepository.getOne(idVenta);
    	
    	v.setPagado(v.getPagado().add(cantidadDeuda));
    	v.setDeuda(v.getDeuda().subtract(cantidadDeuda));
    	
    	if (v.getDeuda().compareTo(BigDecimal.ZERO) <= 0) {
    		v.setDeuda(BigDecimal.ZERO);
    	}
    	
    	ventaRepository.save(v);
    	
    }
    
}