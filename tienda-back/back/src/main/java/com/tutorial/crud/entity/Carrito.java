package com.tutorial.crud.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrito {
	@EmbeddedId
	private CarritoKey id;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("idProducto")
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("correo")
	@JoinColumn(name = "correo")
	private Usuario usuario;
	
	private int cantidad;

	public CarritoKey getId() {
		return id;
	}

	public void setId(CarritoKey id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Carrito() {}
	
	public Carrito(CarritoKey id, Producto producto, Usuario usuario, int cantidad) {
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
	}
	
	
}
