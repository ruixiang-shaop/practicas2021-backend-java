package com.metaenlace.gestionCitasMedicas.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Medico;

@Transactional
public interface IMedicoRepository extends CrudRepository<Medico, Long>{
	
	public Medico findByNumColegiado(String numColegiado);

	Medico findById(long id);
	
}
