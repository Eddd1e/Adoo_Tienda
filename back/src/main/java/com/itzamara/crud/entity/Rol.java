package com.itzamara.crud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
//	@JsonIgnore
//	@OneToOne(mappedBy="rol",cascade = CascadeType.ALL, orphanRemoval = true)
//    private Usuario user;
	
	public Rol() {
		
	}

	public Rol(int id, String nombre, Usuario user) {
		this.id = id;
		this.nombre = nombre;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
