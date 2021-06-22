package com.tutorial.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Carrito;
import com.tutorial.crud.entity.Venta;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
	
	@Query("select v from Carrito v where lower(v.usuario.correo) = lower(:correo)")
	public List<Carrito> findByCorreo( @Param("correo") String correo);
}
