package com.tutorial.crud.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.tutorial.crud.entity.Rol;

public class UsuarioDto {
	public UsuarioDto(String correo, String password,String nombre, String telefono, int clienteFrecuente, Date fechaRegistro, int id_rol) {
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
		this.nombre = nombre;
		this.clienteFrecuente = clienteFrecuente;
		this.fechaRegistro = fechaRegistro;
		this.id_rol = id_rol;
	}

	private String correo;
	private String password;
	private String telefono;
	private String nombre;
	private int clienteFrecuente;
	private Date fechaRegistro;
	private int id_rol;

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
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

	@Override
	public String toString() {
		return "UsuarioDto [correo=" + correo + ", password=" + password + ", telefono=" + telefono
				+ ", clienteFrecuente=" + clienteFrecuente + ", fechaRegistro=" + fechaRegistro + ", id_rol=" + id_rol
				+ "]";
	}
	
}
