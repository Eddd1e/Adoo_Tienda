package com.itzamara.crud.sesion;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String correoUsuario;
    @NotBlank
    private String password;

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String nombreUsuario) {
        this.correoUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
