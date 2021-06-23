package com.itzamara.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itzamara.crud.entity.VentaProducto;



public interface VentaProductoRepository extends JpaRepository<VentaProducto, Integer>  {
	 //TODO qrys union tablas
}
