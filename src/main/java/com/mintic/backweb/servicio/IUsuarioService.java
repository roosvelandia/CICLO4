package com.mintic.backweb.servicio;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mintic.backweb.modelo.LoginDto;
import com.mintic.backweb.modelo.Usuario;
import com.mintic.backweb.modelo.UsuarioDTO;

public interface IUsuarioService {
	
	int login(LoginDto usuarioDto);

	ResponseEntity<?> ingresar(LoginDto usuarioDto);
	
	List<Usuario> getUsuarios();
	
	Usuario nuevoUsuario(UsuarioDTO usuarioDto);
	
	Usuario buscarUsuario(Long id);
	
	int borrarUsuario(Long id);
	
}
