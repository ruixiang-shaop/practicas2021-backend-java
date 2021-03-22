package com.metaenlace.gestionCitasMedicas.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Medico;

@Transactional
public interface IMedicoRepository extends CrudRepository<Medico, Long>{
	
	public Medico findByNumColegiado(String numColegiado);

	Medico findById(long id);
	
	// Used to get one random Medico
	long count(); 
	Page<Medico> findAll(Pageable pageable);

}
