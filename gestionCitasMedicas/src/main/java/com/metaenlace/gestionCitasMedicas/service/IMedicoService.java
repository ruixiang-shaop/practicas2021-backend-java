package com.metaenlace.gestionCitasMedicas.service;

import java.util.List;
import java.util.Optional;

import com.metaenlace.gestionCitasMedicas.entity.Medico;

public interface IMedicoService {
	
	public List<Medico> findAll();
	public Optional<Medico> findById(Long id);
	public Medico save(Medico medico);
	public boolean delete(Long id);
	public Medico update(Medico medico);
}
