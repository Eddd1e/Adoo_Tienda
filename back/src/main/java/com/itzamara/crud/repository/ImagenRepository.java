package com.itzamara.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Imagen;


@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{
	
//	@Query("select i from Imagen i where i.producto.id = :id")
//	List<Imagen> findByIdProducto(@Param("id") int id);
//	
}
