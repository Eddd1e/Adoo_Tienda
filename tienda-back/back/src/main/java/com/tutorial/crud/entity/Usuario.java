package com.tutorial.crud.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario")
public class Usuario {
	public Usuario() {
		
	}

	@Id
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "clienteFrecuente")
	private int clienteFrecuente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@OneToMany(mappedBy = "usuario")
	List<Carrito> carrito;
	
	@OneToOne
	@JoinColumn(name="id_rol")
	private Rol rol;
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getClienteFrecuente() {
		return clienteFrecuente;
	}

	public void setClienteFrecuente(int clienteFrecuente) {
		this.clienteFrecuente = clienteFrecuente;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public List<Carrito> getCarrito() {
		return carrito;
	}
	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario(String correo, String password,String nombre, String telefono, int clienteFrecuente,
			List<Carrito> carrito, Rol rol) {
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
		this.nombre = nombre;
		this.clienteFrecuente = clienteFrecuente;
		this.fechaRegistro = new Date();
		this.carrito = carrito;
		this.rol = rol;
	}
	
	
}
