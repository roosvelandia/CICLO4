package com.mintic.tiendafront.controlador;

import java.nio.file.Path;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mintic.tiendafront.cliente.IClienteTienda;
import com.mintic.tiendafront.cliente.IProductosTienda;
import com.mintic.tiendafront.modelo.Files;
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
		
	@PostMapping("/productos")
    public String uploadFile(Model model,@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        // check if file is empty
        //if (file.isEmpty()) {
          //  attributes.addFlashAttribute("message", "Please select a file to upload.");
            //return "redirect:/";
        //}

        // normalize the file path
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // save the file on the local file system
//        try {
  //          Path path = Paths.get(UPLOAD_DIR + fileName);
    //        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
      //  } catch (IOException e) {
        //    e.printStackTrace();
        //}

        // return success response
//        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
		Files files = new Files();
		files.setFilepath(file.getOriginalFilename());
		int resultado = productosTienda.cargar(files);
		List<Productos> listaProductos = productosTienda.productos();
		model.addAttribute("listaProductos", listaProductos);
		return "productos";
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
