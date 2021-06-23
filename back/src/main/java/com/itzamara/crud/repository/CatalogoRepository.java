package com.itzamara.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Catalogo;
import com.itzamara.crud.entity.Pago;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    Optional<Catalogo> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    

}
