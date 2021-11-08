package com.mintic.backweb.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mintic.backweb.modelo.LoginDto;
import com.mintic.backweb.modelo.Productos;
import com.mintic.backweb.modelo.Usuario;
import com.mintic.backweb.repositorio.IProductos;
import com.mintic.backweb.repositorio.IUsuario;
/*
 * Implementamos la interface con sus metodos
 * @Service  indica la logina empresarial toda la logica de negocio */
@Service
public class ProductosImp implements IProductosService {

	/*
	 * @Autowired inyeccion de dependencia  en este caso para acceder a los metodos del repositorio IUsuario
	 *  (accedemos al login)
	 * */
	@Autowired
	IProductos iProductos;
	/*
	 * Motodo para validar si existe el usuario
	 */


	@Override
	public ResponseEntity<?> listar_P() {
		System.out.println("In backend service");
		Map<String, Object> response = new HashMap<>();
		Productos prods = null;	
		try {
			System.out.println("In backend service2");
			prods = iProductos.findProductos();
			System.out.println("In backend service3" + prods);
			 if (prods ==null) {
				 response.put("Productos", null);
				 response.put("Mensaje", "Alerta:No hay productos");
				 response.put("statusCode", HttpStatus.NOT_FOUND.value());
				 return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		 	
			 }else {
				 response.put("Usuario", prods);
				 response.put("Mensaje", "Productos listados");
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

}
