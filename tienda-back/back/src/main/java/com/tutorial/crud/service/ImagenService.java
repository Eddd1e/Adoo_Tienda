package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Imagen;
import com.tutorial.crud.repository.ImagenRepository;


@Service
@Transactional
public class ImagenService {

//    @Autowired
//    ImagenRepository imagenRepository;
//
//    public List<Imagen> list(){
//        return imagenRepository.findAll();
//    }
//
//    public List<Imagen> getImagenesById(int id){
//        return imagenRepository.findByIdProducto(id);
//    }
//
//    public void  saveLista(List<Imagen> r){
//    	for(Imagen i : r) {
//    		imagenRepository.save(i);
//    	}
//    }
//    
//    public void  save(Imagen r){
//		imagenRepository.save(r);
//    }
//
//    public void delete(int id){
//    	imagenRepository.deleteById(id);
//    }
//
//    public boolean existsById(int id){
//        return imagenRepository.existsById(id);
//    }
//
// 
}