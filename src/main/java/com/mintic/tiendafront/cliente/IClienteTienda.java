package com.mintic.tiendafront.cliente;

import java.util.List;

import com.mintic.tiendafront.modelo.LoginDto;
import com.mintic.tiendafront.modelo.TipoDocumento;
import com.mintic.tiendafront.modelo.Usuario;
import com.mintic.tiendafront.modelo.UsuarioResponse;

public interface IClienteTienda {
	
	public int login(LoginDto loginDto);
	public List<UsuarioResponse> getUsuarios();
	public UsuarioResponse nuevoUsuario(Usuario usuarioDto);
	public UsuarioResponse buscarUsuario(Long id);
	public int borrarUsuario(Long id);
	public List<TipoDocumento> getTipoDocumento();
}
