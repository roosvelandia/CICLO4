package com.mintic.backweb.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.backweb.modelo.LoginDto;
import com.mintic.backweb.modelo.Productos;
import com.mintic.backweb.repositorio.ITipoDocumento;
import com.mintic.backweb.servicio.IProductosService;
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
	IProductosService iProductos;
	
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
	
	//@PostMapping("/productos") // ruta del servicio desde el front deben direccionar a esta ruta
	//public ResponseEntity<?> Productsview() {
		//ResponseEntity<?> listaProductos = iProductos.listar_P();
		//System.out.println(listaProductos);
		//return iProductos.listar_P();
	//}
	@GetMapping("/productos") // ruta del servicio desde el front deben direccionar a esta ruta
	public List<Productos> Productsview() {
		List<Productos> listaProductos = servicio.listar();
		System.out.println(listaProductos);
		return listaProductos;
	}
	
	

}
