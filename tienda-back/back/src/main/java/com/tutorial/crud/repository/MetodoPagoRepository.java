package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.MetodoPago;
import com.tutorial.crud.entity.Pago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

}
