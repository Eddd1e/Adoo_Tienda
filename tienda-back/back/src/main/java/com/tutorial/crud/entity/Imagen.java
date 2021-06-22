package com.tutorial.crud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="imagen")
public class Imagen {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "imagen")
	private String imagen;
	
	@JsonIgnore
	@OneToMany
	private List<ImagenProducto> imagenProducto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<ImagenProducto> getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(List<ImagenProducto> imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	
	public Imagen() {
		// TODO Auto-generated constructor stub
	}

	public Imagen(int id, String imagen, List<ImagenProducto> imagenProducto) {
		this.id = id;
		this.imagen = imagen;
		this.imagenProducto = imagenProducto;
	}
	
}
