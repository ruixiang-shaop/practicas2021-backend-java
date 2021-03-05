package com.metaenlace.gestionCitasMedicas.service;

import java.util.List;
import java.util.Optional;

import com.metaenlace.gestionCitasMedicas.entity.Paciente;

public interface IPacienteService {
	
	public List<Paciente> findAll();
	public Optional<Paciente> findById(Long id);
	public Paciente save(Paciente paciente);
	public boolean delete(Long id);
	public boolean update(Paciente paciente);
}
