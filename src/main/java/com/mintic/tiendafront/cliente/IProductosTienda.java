package com.mintic.tiendafront.cliente;

import java.util.List;

import com.mintic.tiendafront.modelo.Files;
import com.mintic.tiendafront.modelo.Productos;

public interface IProductosTienda {
	
	public List<Productos> productos();
	public int cargar(Files file);

}
