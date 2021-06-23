package com.itzamara.crud.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class VentaProducto {
	
    @EmbeddedId
    private VentaProductoKey id;
	
    @ManyToOne
    @MapsId("idProducto")
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
    
    @JsonIgnore
    @ManyToOne
    @MapsId("idVenta")
	@JoinColumn(name = "id_venta")
	private Venta venta;
	
    private int cantidad;
    
	public VentaProducto(VentaProductoKey id,Producto producto, Venta venta, int cantidad) {
		this.id = id;
		this.producto = producto;
		this.venta = venta;
		this.cantidad = cantidad;
	}
	
	public VentaProductoKey getId() {
		return id;
	}

	public void setId(VentaProductoKey id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public VentaProducto() {}
	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	
	
}
