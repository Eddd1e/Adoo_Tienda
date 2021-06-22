package com.tutorial.crud.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @OneToOne
    @JoinColumn(name="id_proveedor")
    private Proveedor proveedor;
    
    @OneToOne
    @JoinColumn(name="id_catalogo")
    private Catalogo catalogo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precio")
    private float precio;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @JsonIgnore
	@OneToOne(mappedBy="rol")
    private Usuario user;
    
    @ManyToMany(mappedBy = "productoVenta")
    List<Venta> productosVenta;
    
    @OneToMany(mappedBy = "producto")
    List<Carrito> carritos;
    
    @OneToOne
    @JoinColumn(name="id_recurso")
    private Recurso recurso;
    
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_cad")
	private Date fecha_cad;

    public Producto() {
    }
    
    public Producto( Proveedor proveedor, Catalogo catalogo, String nombre, int cantidad, float precio,
			String descripcion, Recurso recurso) {	
		this.proveedor = proveedor;
		this.catalogo = catalogo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.recurso = recurso;
		this.fecha_cad = new Date();

	}



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setId_proveedor(Proveedor id_proveedor) {
		this.proveedor = id_proveedor;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
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

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}


	public Date getFecha_cad() {
		return fecha_cad;
	}

	public void setFecha_cad(Date fecha_cad) {
		this.fecha_cad = fecha_cad;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	

    
}
