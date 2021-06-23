package com.itzamara.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VentaProductoKey implements Serializable{
	
	@Column( name = "id_producto")
	private int idProducto;
	
	@Column( name = "id_Venta")
	private int idVenta;
	
	
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		result = prime * result + idVenta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VentaProductoKey other = (VentaProductoKey) obj;
		if (idProducto != other.idProducto)
			return false;
		if (idVenta != other.idVenta)
			return false;
		return true;
	}
	
	
}
