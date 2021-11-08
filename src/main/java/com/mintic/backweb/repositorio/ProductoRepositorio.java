package com.mintic.backweb.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mintic.backweb.modelo.Productos;
import com.mintic.backweb.modelo.Usuario;

public interface ProductoRepositorio extends JpaRepository<Productos, Integer>{
	
	
}
