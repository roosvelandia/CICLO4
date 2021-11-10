package com.mintic.tiendafront.modelo;

public class TipoDocumento {

	private Long id;
	private String tipo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public TipoDocumento(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public TipoDocumento() {
		super();
	}
	

}
