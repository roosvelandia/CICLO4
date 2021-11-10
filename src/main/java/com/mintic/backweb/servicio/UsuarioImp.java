package com.mintic.backweb.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mintic.backweb.modelo.LoginDto;
import com.mintic.backweb.modelo.TipoDocumento;
import com.mintic.backweb.modelo.Usuario;
import com.mintic.backweb.modelo.UsuarioDTO;
import com.mintic.backweb.repositorio.IUsuario;
/*
 * Implementamos la interface con sus metodos
 * @Service  indica la logina empresarial toda la logica de negocio */
@Service
public class UsuarioImp implements IUsuarioService {

	/*
	 * @Autowired inyeccion de dependencia  en este caso para acceder a los metodos del repositorio IUsuario
	 *  (accedemos al login)
	 * */
	@Autowired
	IUsuario iUsuario;
	/*
	 * Motodo para validar si existe el usuario
	 */

	@Override
	public int login(LoginDto usuarioDto) {
		int u = iUsuario.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return u;
	}

	@Override
	public ResponseEntity<?> ingresar(LoginDto usuarioDto) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuario = null;	
		try {
			usuario = iUsuario.findByNameAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
			 if (usuario ==null) {
				 response.put("Usuario", null);
				 response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
				 response.put("statusCode", HttpStatus.NOT_FOUND.value());
				 return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		 	
			 }else {
				 response.put("Usuario", usuario);
				 response.put("Mensaje", "Datos correctos");
				 response.put("statusCode", HttpStatus.OK.value());
				 return new ResponseEntity<>(response, HttpStatus.OK);
			 }
		} catch (Exception e) {
			 response.put("Usuario", null);
			 response.put("Mensaje", "Ha ocurrido un error");
			 response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			 return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) iUsuario.findAll();
	}

	@Override
	public Usuario nuevoUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		TipoDocumento td = new TipoDocumento();
		td.setId(usuarioDto.getIdTipoDocumento());
		
		if (usuarioDto.getId()!=null) {
			usuario.setId(usuarioDto.getId());
		}
		
		usuario.setIdTipoDocumento(td);
		usuario.setNumeroDocumento(usuarioDto.getNumeroDocumento());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setEmail(usuarioDto.getEmail());
		return iUsuario.save(usuario);
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		Usuario usuario = null;
		usuario = iUsuario.findById(id).orElse(null);
		if (usuario == null) {
			return null;
		}
		
		return usuario;
	}

	@Override
	public int borrarUsuario(Long id) {
		iUsuario.deleteById(id);
		return 1;
	}

}
