package com.tutorial.crud.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@OneToOne
    @JoinColumn(name="correo")
	private Usuario usuario;
	
	@Column(name = "deuda")
	private BigDecimal deuda;
	
	@Column(name = "pagado")
	private BigDecimal pagado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha")
	private Date fecha;
	
	
	@ManyToMany
	@JoinTable(
	  name = "venta_producto", 
	  joinColumns = @JoinColumn(name = "id_producto"), 
	  inverseJoinColumns = @JoinColumn(name = "id_Venta"))
	private List<Producto> productoVenta;
	
	public Venta() {}
	
	
	public Venta(int id, Usuario usuario, BigDecimal deuda, BigDecimal pagado, Date fecha,
			List<Producto> productoVenta) {
		this.id = id;
		this.usuario = usuario;
		this.deuda = deuda;
		this.pagado = pagado;
		this.fecha = fecha;
		this.productoVenta = productoVenta;
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
	public BigDecimal getDeuda() {
		return deuda;
	}
	public void setDeuda(BigDecimal deuda) {
		this.deuda = deuda;
	}
	public BigDecimal getPagado() {
		return pagado;
	}
	public void setPagado(BigDecimal pago) {
		this.pagado = pago;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Producto> getProductoVenta() {
		return productoVenta;
	}

	public void setProductoVenta(List<Producto> productoVenta) {
		this.productoVenta = productoVenta;
	}


	
	
	

}
