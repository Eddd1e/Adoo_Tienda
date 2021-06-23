package com.itzamara.crud.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "pago")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@OneToOne
    @JoinColumn(name="correo")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="id_metodo")
	private MetodoPago metodoPago;
	
	@OneToOne
	@JoinColumn(name="id_venta")
	private Venta venta;
	
	@Column(name = "cantidad")
	private BigDecimal cantidad;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha")
	private Date fecha;
	
	public Pago() {}
	
	public Pago( Usuario usuario, MetodoPago metodoPago, Venta venta, BigDecimal cantidad) {
		
		this.usuario = usuario;
		this.metodoPago = metodoPago;
		this.venta = venta;
		this.cantidad = cantidad;
		this.fecha = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
