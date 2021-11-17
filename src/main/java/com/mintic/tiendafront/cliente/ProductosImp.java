package com.mintic.tiendafront.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.modelo.Files;
import com.mintic.tiendafront.modelo.LoginDto;
import com.mintic.tiendafront.modelo.Productos;

import reactor.core.publisher.Mono;

@Service
public class ProductosImp implements IProductosTienda {

	// URL del Backend incluye contextPath definido en el servidor
	private static final String URL = "http://localhost:8090/tiendagenerica/v1";

	@Autowired
	private WebClient.Builder webClient;
	
	List<Productos> empt;
	@Override
	public List<Productos> productos() {
		
		try {
			/*
			 * aqui nos conectamos al back  directamente al controlador donde estan las rutas 
			 * el back espera recibir un dto  por eso enviamos el dto login dto
			  * */
			Mono<List> response2 = webClient.build().get().uri(URL + "/productos").retrieve()
					.bodyToMono(List.class);
			return response2.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return empt;
		}
	}
	@Override
	public int cargar(Files file) {
		try {
			Mono<Integer> response = webClient.build().post().uri(URL + "/productos")
					.accept(MediaType.APPLICATION_JSON).body(Mono.just(file), Files.class).retrieve()
					.bodyToMono(Integer.class);
			System.out.println(response);
			return response.block();
		} catch(WebClientResponseException e) {
			e.getMessage();
			System.out.println("----->" + e.getMessage());
			return 0;
		}
	}

}
