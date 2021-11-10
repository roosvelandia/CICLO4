package com.mintic.tiendafront.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.tiendafront.cliente.IClienteTienda;
import com.mintic.tiendafront.cliente.IProductosTienda;
//import com.mintic.tiendafront.cliente.IProductosTienda;
import com.mintic.tiendafront.modelo.LoginDto;
//import com.mintic.tiendafront.modelo.Productos;
import com.mintic.tiendafront.modelo.Productos;
import com.mintic.tiendafront.modelo.Usuario;
import com.mintic.tiendafront.modelo.UsuarioResponse;

@Controller
public class AppControlador {

	@Autowired
	IClienteTienda clienteTienda;
	
	@Autowired
	IProductosTienda productosTienda;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@PostMapping("/login")
	public String login(Model model, LoginDto loginDto) {
		int validLogin = clienteTienda.login(loginDto);

		if (validLogin == 1) {
			return "menu";
		} else {
			model.addAttribute("error", "Usuario o constraseña invalidos.");
			return "index";
		}

	}
	
	@GetMapping("/productos")
	public String productos(Model model) {
		List<Productos> listaProductos = productosTienda.productos();
		model.addAttribute("listaProductos", listaProductos);
		return "productos";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		
		Usuario usuarioEditar = new Usuario();
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		model.addAttribute("usuarioEditar", usuarioEditar );
		return "usuarios";
	}
	
	@PostMapping("/usuarios")
	public String crearUsuario(Model model, Usuario usuario) {
		Usuario usuarioEditar = new Usuario();
		clienteTienda.nuevoUsuario(usuario);
		
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		model.addAttribute("usuarioEditar", usuarioEditar );
		return "usuarios";
	}
	
	@GetMapping("/usuario/{id}")
	public String actualizarUsuario(Model model, @PathVariable(name = "id") Long id) {
		UsuarioResponse usuarioEditar = clienteTienda.buscarUsuario(id);
		model.addAttribute("usuarioEditar", usuarioEditar);
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuarios";
	}
	
	@GetMapping("/eliminarusuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") Long id) {
		System.out.println("En controlador");
		Usuario usuarioEditar = new Usuario();
		clienteTienda.borrarUsuario(id);
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		model.addAttribute("usuarioEditar", usuarioEditar);
		
		return "usuarios";
	}
	
}
