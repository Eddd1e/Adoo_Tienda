package com.itzamara.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    Optional<Proveedor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}