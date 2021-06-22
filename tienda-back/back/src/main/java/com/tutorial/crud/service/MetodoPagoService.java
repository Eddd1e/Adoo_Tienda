package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.MetodoPago;
import com.tutorial.crud.entity.Pago;
import com.tutorial.crud.repository.MetodoPagoRepository;

@Service
@Transactional
public class MetodoPagoService {
	
	@Autowired
	MetodoPagoRepository metodoPagoRepostory;
	
	public List<MetodoPago> list(){
        return metodoPagoRepostory.findAll();
    }
	
    public Optional<MetodoPago> getOne(int id){
        return metodoPagoRepostory.findById(id);
    }
}
