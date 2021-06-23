package com.itzamara.crud.dto;

import com.itzamara.crud.entity.Producto;

public class CarritoDto {
	
	private Producto p;
	private int cantidad;
	public Producto getP() {
		return p;
	}
	public void setP(Producto p) {
		this.p = p;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public CarritoDto(Producto p, int cantidad) {
		this.p = p;
		this.cantidad = cantidad;
	}
	public CarritoDto() {
		// TODO Auto-generated constructor stub
	}
	
}
