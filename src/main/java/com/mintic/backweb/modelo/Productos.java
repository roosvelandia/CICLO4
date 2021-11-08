package com.mintic.backweb.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Productos {
	@Id
	@NotNull
	private int codigo;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@Min(value=1)
	private int nitproveedor;
	
	@NotNull
	private double precio_compra;
	
	@Min(value = 0)
	@Max(value = 35)
	private double iva;
	
	@NotNull
	private double precio_venta;
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Productos(int codigo, String nombre, int nitproveedor, double precio_compra, double iva,
			double precio_venta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.iva = iva;
		this.precio_venta = precio_venta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	@Override
	public String toString() {
		return "productos [codigo=" + codigo + ", nombre=" + nombre + ", nitproveedor=" + nitproveedor
				+ ", precio_compra=" + precio_compra + ", iva=" + iva + ", precio_venta=" + precio_venta + "]";
	}
	
	
}
