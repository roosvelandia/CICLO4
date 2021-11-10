package com.mintic.backweb.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mintic.backweb.modelo.Productos;


/*
 * Aqui se realizan las opereciones crud   
 *  los parametros son la entidad  y el tipo de datos que se definio como @id en la entidad  
 * 
	el id es long debe ir igual en el crud repository <Usuario, Long>
 * 
 * 
 * */
public interface IProductos extends CrudRepository<Productos, Long>{
	
	// JPQL: Se hace la consulta sobre la clase 
	@Query("select p from Productos as p")
	List<Productos> findProductos();

}
