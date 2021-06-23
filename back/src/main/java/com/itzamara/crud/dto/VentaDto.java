package com.itzamara.crud.dto;

import java.math.BigDecimal;
import java.util.Date;



import org.springframework.data.annotation.CreatedDate;

import com.itzamara.crud.entity.Usuario;

public class VentaDto {
	private int id;
	private BigDecimal deuda;
	private BigDecimal pagado;
	private Date fecha;
	private int productos[];
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int[] getProductos() {
		return productos;
	}
	public void setProductos(int[] productos) {
		this.productos = productos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getDeuda() {
		return deuda;
	}
	public void setDeuda(BigDecimal deuda) {
		this.deuda = deuda;
	}
	public BigDecimal getPagado() {
		return pagado;
	}
	public void setPagado(BigDecimal pagado) {
		this.pagado = pagado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public VentaDto(int id, BigDecimal deuda, BigDecimal pagado, Date fecha, int[]productos) {
		this.id = id;
		this.deuda = deuda;
		this.pagado = pagado;
		this.fecha = fecha;
		this.productos = productos;
	}
	public VentaDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
