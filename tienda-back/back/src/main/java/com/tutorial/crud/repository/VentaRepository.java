package com.tutorial.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tutorial.crud.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
  //TODO poner qry jdb para buscar por correo
	
	@Query("select v from Venta v where lower(v.usuario.correo) = lower(:correo)")
	public Optional<Venta> findByCorreo( @Param("correo") String correo);
}