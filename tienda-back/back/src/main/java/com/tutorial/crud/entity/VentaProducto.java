package com.tutorial.crud.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class VentaProducto {
	
    @EmbeddedId
    private VentaProductoKey id;
	
    @ManyToOne
    @MapsId("idProducto")
	@JoinColumn(name = "id_producto")
	private Producto producto;
	

    @ManyToOne
    @MapsId("idVenta")
	@JoinColumn(name = "id_venta")
	private Venta venta;
	

	public VentaProducto(VentaProductoKey id,Producto producto, Venta venta) {
		this.id = id;
		this.producto = producto;
		this.venta = venta;
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
