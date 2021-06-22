package com.tutorial.crud.sesion;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.UsuarioDto;
import com.tutorial.crud.entity.Carrito;
import com.tutorial.crud.entity.Usuario;
import com.tutorial.crud.jwt.JwtProvider;
import com.tutorial.crud.service.CarritoService;
import com.tutorial.crud.service.RolService;
import com.tutorial.crud.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	CarritoService carritoService;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody UsuarioDto nuevoUsuario) {
//        if(bindingResult.hasErrors())
//            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
//        
	
//		usuarioService.encontrarPorCorreo(nuevoUsuario.getCorreo())
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
//						String.format("ese correo ya existe %s", nuevoUsuario.getCorreo())));
		List<Carrito> carritos = carritoService.findByCorreo(nuevoUsuario.getCorreo());

		Usuario u = new Usuario(nuevoUsuario.getCorreo(),passwordEncoder.encode(nuevoUsuario.getPassword()) , nuevoUsuario.getNombre(),
				nuevoUsuario.getTelefono(), nuevoUsuario.getClienteFrecuente(), carritos,
				rolService.getOne(nuevoUsuario.getId_rol()).get());

		usuarioService.save(u);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getCorreoUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
