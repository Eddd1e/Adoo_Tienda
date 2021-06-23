package com.itzamara.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itzamara.crud.entity.MetodoPago;
import com.itzamara.crud.entity.Pago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

}
