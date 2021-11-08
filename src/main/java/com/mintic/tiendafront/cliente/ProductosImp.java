package com.mintic.tiendafront.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.modelo.LoginDto;
import com.mintic.tiendafront.modelo.Productos;

import reactor.core.publisher.Mono;

@Service
public class ProductosImp implements IProductosTienda {

	// URL del Backend incluye contextPath definido en el servidor
	private static final String URL = "http://localhost:8090/tiendagenerica/v1";

	@Autowired
	private WebClient.Builder webClient;
	
	List<Productos> empty;
	@Override
	public List<Productos> productos() {
		System.out.println("after sending1");
		try {
			/*
			 * aqui nos conectamos al back  directamente al controlador donde estan las rutas 
			 * el back espera recibir un dto  por eso enviamos el dto login dto
			  * */
			System.out.println("after sending2");
			
			Mono<Productos> response = webClient.build().post().uri(URL + "/productos")
				.accept(MediaType.APPLICATION_JSON).body(Mono.justOrEmpty(null), Productos.class).retrieve()
					.bodyToMono(Productos.class);
			//Aqui se captura la respuesta del back 
			
			System.out.println(response.block());
			
			return (List<Productos>) response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return empty;
		}
	}

}
