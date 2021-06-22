package com.tutorial.crud.sesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutorial.crud.entity.Usuario;
import com.tutorial.crud.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String Usuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.encontrarPorCorreo(Usuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
