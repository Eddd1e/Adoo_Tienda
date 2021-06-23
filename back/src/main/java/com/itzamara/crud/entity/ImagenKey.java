package com.itzamara.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class ImagenKey implements Serializable{
	
	
	@Column(name="id_iamgen")
	private int idImagen;
	@Column(name="id_producto")
	private int IdProducto;
	
	
	
	public int getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public ImagenKey(int idImagen, int idProducto) {
		this.idImagen = idImagen;
		IdProducto = idProducto;
	}
	
	public ImagenKey() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdProducto;
		result = prime * result + idImagen;
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
		ImagenKey other = (ImagenKey) obj;
		if (IdProducto != other.IdProducto)
			return false;
		if (idImagen != other.idImagen)
			return false;
		return true;
	}
	
	
}
