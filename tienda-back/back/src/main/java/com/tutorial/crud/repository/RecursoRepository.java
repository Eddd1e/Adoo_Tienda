package com.tutorial.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Recurso;


@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
}
