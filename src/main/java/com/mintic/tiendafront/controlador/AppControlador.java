package com.mintic.tiendafront.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.tiendafront.cliente.IClienteTienda;
import com.mintic.tiendafront.cliente.IProductosTienda;
//import com.mintic.tiendafront.cliente.IProductosTienda;
import com.mintic.tiendafront.modelo.LoginDto;
//import com.mintic.tiendafront.modelo.Productos;
import com.mintic.tiendafront.modelo.Productos;

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
	
}
