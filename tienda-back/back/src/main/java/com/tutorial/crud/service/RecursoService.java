package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Recurso;

import com.tutorial.crud.repository.RecursoRepository;


@Service
@Transactional
public class RecursoService {

    @Autowired
    RecursoRepository recursoRepository;

    public List<Recurso> list(){
        return recursoRepository.findAll();
    }

    public Optional<Recurso> getOne(int id){
        return recursoRepository.findById(id);
    }

    public void  save(Recurso r){
    	recursoRepository.save(r);
    }

    public void delete(int id){
    	recursoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return recursoRepository.existsById(id);
    }

 
}