package com.itzamara.crud.dto;

import javax.persistence.Column;

public class ProveedorDto {

	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	

	public ProveedorDto(String nombre, String telefono, String correo, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}
	
	

	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "ProveedorDto [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
	}

}
