package com.metaenlace.gestionCitasMedicas.service;

import java.util.List;
import java.util.Optional;

import com.metaenlace.gestionCitasMedicas.entity.Cita;

public interface ICitaService {
	
	public List<Cita> findAll();
	public Optional<Cita> findById(Long id);
	public Cita save(Cita cita);
	public boolean delete(Long id);
	public boolean update(Cita cita);
}
