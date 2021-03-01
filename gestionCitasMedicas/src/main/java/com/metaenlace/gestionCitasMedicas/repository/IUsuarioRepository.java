package com.metaenlace.gestionCitasMedicas.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Usuario;

@Transactional
public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

	public List<Usuario> findByNombre(String nombre);
	
	public Usuario findByUsuario(String usuario);
	
	public Usuario findById(long id);
}
