package com.tutorial.crud.sesion;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String correoUsuario;
    private String telefono;
    @NotBlank
    private String password;
    
    private int id_rol;
    
    

    public NuevoUsuario(@NotBlank String nombre, @NotBlank String correoUsuario, String telefono,
			@NotBlank String password, int id_rol) {
		super();
		this.nombre = nombre;
		this.correoUsuario = correoUsuario;
		this.telefono = telefono;
		this.password = password;
		this.id_rol = id_rol;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "NuevoUsuario [nombre=" + nombre + ", correoUsuario=" + correoUsuario + ", telefono=" + telefono
				+ ", password=" + password + ", id_rol=" + id_rol + "]";
	}
    
}
