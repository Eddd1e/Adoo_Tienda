package com.tutorial.crud.dto;

import java.math.BigDecimal;

public class PagoDto {
	private String correo;
	private int id_metodo;
	private int id_venta;
	private BigDecimal cantidad;
	public PagoDto(String correo, int id_metodo, int id_venta, BigDecimal cantidad) {
		super();
		this.correo = correo;
		this.id_metodo = id_metodo;
		this.id_venta = id_venta;
		this.cantidad = cantidad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getId_metodo() {
		return id_metodo;
	}
	public void setId_metodo(int id_metodo) {
		this.id_metodo = id_metodo;
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
}
