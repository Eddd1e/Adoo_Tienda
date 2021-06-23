package com.itzamara.crud.sesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itzamara.crud.entity.Usuario;
import com.itzamara.crud.service.RolService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String nombreUsuario;
    
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    @Autowired
	RolService rolservice;
    public UsuarioPrincipal(String nombre, String nombreUsuario, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
    	//rolservice.getOne(usuario.getId_rol()).get();
    
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getCorreo().toLowerCase(),  usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    
}