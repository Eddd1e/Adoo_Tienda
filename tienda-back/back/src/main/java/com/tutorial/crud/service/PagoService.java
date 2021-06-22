package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Pago;
import com.tutorial.crud.repository.PagoRepository;


@Service
@Transactional
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public List<Pago> list(){
        return pagoRepository.findAll();
    }
    public List<Pago>findAllByCorreo(String correo){
    	return pagoRepository.findAllByCorreo(correo);
    }
    public List<Pago>findByIdVenta(int id){
    	return pagoRepository.findByIdVenta(id);
    }

    public Optional<Pago> getOne(int id){
        return pagoRepository.findById(id);
    }

  

    public void  save(Pago producto){
    	pagoRepository.save(producto);
    }

    public void delete(int id){
    	pagoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return pagoRepository.existsById(id);
    }

}
