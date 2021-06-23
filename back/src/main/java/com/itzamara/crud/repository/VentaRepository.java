package com.itzamara.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
  //TODO poner qry jdb para buscar por correo
	
	@Query("select v from Venta v where v.usuario.correo = :correo")
	public List<Venta> findByCorreo( @Param("correo") String correo);
	
	
}