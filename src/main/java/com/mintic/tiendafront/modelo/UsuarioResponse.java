package com.mintic.tiendafront.modelo;

public class UsuarioResponse {

	private Long id;
	private TipoDocumento idTipoDocumento;
	
	private String numeroDocumento;
	private String nombre;
	private String email;
	private String password;
	private String nombreUsuario;
	
	



	public UsuarioResponse(Long id, TipoDocumento idTipoDocumento, String numeroDocumento, String nombre, String email,
			String password, String nombreUsuario) {
		super();
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}


	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UsuarioResponse() {
		super();
		}

}
