package com.mintic.backweb.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.backweb.modelo.Productos;
import com.mintic.backweb.repositorio.ProductoRepositorio;



@Service
@Transactional
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio repo;
	
	public List<Productos> listar(){
		return repo.findAll();
	}
	
	public Productos listarId(int id) {
		return repo.findById(id).get();
	}
	
	public void save(Productos p) {
		repo.save(p);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}