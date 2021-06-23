package com.itzamara.crud.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Carrito;
import com.itzamara.crud.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
