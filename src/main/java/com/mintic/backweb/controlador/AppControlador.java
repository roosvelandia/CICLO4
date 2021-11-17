package com.mintic.backweb.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.backweb.modelo.Files;
import com.mintic.backweb.modelo.LectorCSV;
import com.mintic.backweb.modelo.LoginDto;
import com.mintic.backweb.modelo.Productos;
import com.mintic.backweb.modelo.TipoDocumento;
import com.mintic.backweb.modelo.Usuario;
import com.mintic.backweb.modelo.UsuarioDTO;
import com.mintic.backweb.repositorio.ITipoDocumento;
import com.mintic.backweb.servicio.IUsuarioService;

import com.mintic.backweb.servicio.ProductoServicio;






@RestController
public class AppControlador {
	
	/*
	 * inyectamos el la iterface del servicio para acceder a los metodos del negocio
	 **/
	
	@Autowired
	IUsuarioService iUsuario;
	
	@Autowired
	ITipoDocumento iTipoDocumento;
	
	@Autowired
	private ProductoServicio servicio;

	/*
	 * @CrossOrigin indica desde que sitios se van a realizar peticiones
	 */
	@CrossOrigin(origins = { "http://localhost:8010" })
	@PostMapping("/loginclient") // ruta del servicio desde el front deben direccionar a esta ruta
	public int login(@RequestBody LoginDto usuario) {
		int responseLogin = iUsuario.login(usuario);
		return responseLogin;
	}

	@PostMapping("/login") // ruta del servicio desde el front deben direccionar a esta ruta
	public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario) {
		return iUsuario.ingresar(usuario);
	}
	
	@GetMapping("/productos") // ruta del servicio desde el front deben direccionar a esta ruta
	public List<Productos> Productsview() {
		List<Productos> listaProductos = servicio.listar();
		System.out.println(listaProductos);
		return listaProductos;
	}
	
	
	@PostMapping("/usuarios") // ruta del servicio desde el front deben direccionar a esta ruta
	public Usuario usuarios(@RequestBody UsuarioDTO usuarioDto) {
		System.out.println("en controlador");
		return iUsuario.nuevoUsuario(usuarioDto);
	}
	
	@GetMapping("/usuarios") // ruta del servicio desde el front deben direccionar a esta ruta
	public List<Usuario> listarUsuarios() {
		return iUsuario.getUsuarios();
	}
	
	@GetMapping("/usuarios/{id}") // ruta del servicio desde el front deben direccionar a esta ruta
	public Usuario  buscarUsuarioId(@PathVariable Long id) {
		return iUsuario.buscarUsuario(id);
	}
	
	@PostMapping("/productos") // ruta del servicio desde el front deben direccionar a esta ruta
	public int  cargarProductos(@RequestBody Files file) throws IOException {
		LectorCSV lectorCSV = new LectorCSV(',',' ');
		List<Productos> productos = lectorCSV.LeerCSVSimple(file.getFilepath());
		for (Productos producto :productos) {
			System.out.println(producto);
			servicio.save(producto);
		}
		return 0;
	}
	
	@DeleteMapping("/usuarios/{id}") // ruta del servicio desde el front deben direccionar a esta ruta
	public int  eliminarUsuario(@PathVariable Long id) {
		return iUsuario.borrarUsuario(id);
	}
	
	@GetMapping("/tiposdocumento") // ruta del servicio desde el front deben direccionar a esta ruta
	public List<TipoDocumento> listarTipoDocumento() {
		return (List<TipoDocumento>) iTipoDocumento.findAll();
	}
	
	

}
