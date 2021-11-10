package com.mintic.backweb.modelo;

public class UsuarioDTO {

	private Long id;
	private Long idTipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String password;
	private String nombreUsuario;
	private String email;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long id, Long idTipoDocumento, String numeroDocumento, String nombre, String password,
			String nombreUsuario, String email) {
		super();
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
