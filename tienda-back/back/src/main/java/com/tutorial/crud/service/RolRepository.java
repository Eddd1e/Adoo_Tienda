package com.tutorial.crud.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Carrito;
import com.tutorial.crud.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
