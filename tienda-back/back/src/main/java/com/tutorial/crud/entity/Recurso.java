package com.tutorial.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "recurso")
public class Recurso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;

	@Lob
	@Column(length=100000,name = "recurso")
	private byte[] recurso;
	
	@JsonIgnore
	@OneToOne(mappedBy="recurso")
	private Producto producto;
	
	public Recurso() {}

	public Recurso(int id, byte[] recurso) {
		super();
		this.id = id;
		this.recurso = recurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getRecurso() {
		return recurso;
	}

	public void setRecurso(byte[] recurso) {
		this.recurso = recurso;
	}
	
	
}