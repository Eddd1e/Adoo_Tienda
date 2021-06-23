package com.itzamara.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Pago;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
	
	
	@Query("select v from Pago v where v.venta.id = :id")
	public List<Pago> findByIdVenta( @Param("id") int id);
	
	@Query("select p from Pago p where p.usuario.correo = :correo")
	public List<Pago> findAllByCorreo( @Param("correo") String correo);
}
