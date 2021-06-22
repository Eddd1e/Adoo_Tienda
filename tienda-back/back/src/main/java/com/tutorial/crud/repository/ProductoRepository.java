package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    Optional<Producto> findById(int id);
    
    @Query("select c from Producto c where c.catalogo.id = :id")
	public List<Producto> findAllProductoByIdCatalogo( @Param("id") int id);
}
