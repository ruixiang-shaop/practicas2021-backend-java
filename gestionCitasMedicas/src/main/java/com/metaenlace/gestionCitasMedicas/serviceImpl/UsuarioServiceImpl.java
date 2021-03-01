package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.gestionCitasMedicas.entity.Usuario;
import com.metaenlace.gestionCitasMedicas.repository.IUsuarioRepository;
import com.metaenlace.gestionCitasMedicas.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return Optional.ofNullable(usuarioRepository.findByUsuario(usuario));
	}
}
