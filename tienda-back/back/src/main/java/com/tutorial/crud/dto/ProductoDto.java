package com.tutorial.crud.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;

public class ProductoDto {

    @NotBlank
    private String nombre;
    @Min(0)
    private Float precio;
    
    private int id_proveedor;
    
    private int id_catalogo;
    
    private int cantidad;
   
    private String descripcion;
 
    private int id_recurso;
 
	private Date fecha_cad;

    public ProductoDto() {
    }
    
    public ProductoDto(@NotBlank String nombre, @Min(0) Float precio, int id_proveedor, int id_catalogo, int cantidad,
			String descripcion, int id_recurso, Date fecha_cad) {
	
		this.nombre = nombre;
		this.precio = precio;
		this.id_proveedor = id_proveedor;
		this.id_catalogo = id_catalogo;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.id_recurso = id_recurso;
		this.fecha_cad = fecha_cad;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }


	public int getId_proveedor() {
		return id_proveedor;
	}


	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}


	public int getId_catalogo() {
		return id_catalogo;
	}


	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getId_recurso() {
		return id_recurso;
	}


	public void setId_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
	}


	public Date getFecha_cad() {
		return fecha_cad;
	}


	public void setFecha_cad(Date fecha_cad) {
		this.fecha_cad = fecha_cad;
	}


	@Override
	public String toString() {
		return "ProductoDto [nombre=" + nombre + ", precio=" + precio + ", id_proveedor=" + id_proveedor
				+ ", id_catalogo=" + id_catalogo + ", cantidad=" + cantidad + ", descripcion=" + descripcion
				+ ", id_recurso=" + id_recurso + ", fecha_cad=" + fecha_cad + "]";
	}
    
    
}
