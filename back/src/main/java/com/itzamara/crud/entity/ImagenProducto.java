package com.itzamara.crud.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ImagenProducto {
	@EmbeddedId
	private ImagenKey id;
	
	@ManyToOne
	@MapsId("idImagen")
	@JoinColumn(name = "id_imagen")
	private Imagen imagen;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("idProducto")
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public ImagenProducto() {
		// 
	}
	
	public ImagenKey getId() {
		return id;
	}

	public void setId(ImagenKey id) {
		this.id = id;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ImagenProducto(ImagenKey id, Imagen imagen, Producto producto) {
		this.id = id;
		this.imagen = imagen;
		this.producto = producto;
	}
	
	
}
