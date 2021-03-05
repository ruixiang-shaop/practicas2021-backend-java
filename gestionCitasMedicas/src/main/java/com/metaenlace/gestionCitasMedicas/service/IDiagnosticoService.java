package com.metaenlace.gestionCitasMedicas.service;

import java.util.List;
import java.util.Optional;

import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;

public interface IDiagnosticoService {
	
	public List<Diagnostico> findAll();
	public Optional<Diagnostico> findById(Long id);
	public Diagnostico save(Diagnostico diag);
	public boolean delete(Long id);
	public boolean update(Diagnostico diag);
}
