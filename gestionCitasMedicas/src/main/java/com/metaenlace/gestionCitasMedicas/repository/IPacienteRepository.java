package com.metaenlace.gestionCitasMedicas.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Paciente;

@Transactional
public interface IPacienteRepository extends CrudRepository<Paciente, Long> {

	public Paciente findByNss(String nss);
	
	Paciente findById(long id);
	
}
