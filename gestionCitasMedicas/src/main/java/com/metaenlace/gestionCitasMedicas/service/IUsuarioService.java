package com.metaenlace.gestionCitasMedicas.service;

import java.util.Optional;

import com.metaenlace.gestionCitasMedicas.entity.Usuario;

public interface IUsuarioService {
	
	public Optional<Usuario> findByUsuario(String usuario);
}
