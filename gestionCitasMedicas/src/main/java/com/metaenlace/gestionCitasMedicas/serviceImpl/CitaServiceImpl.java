package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.gestionCitasMedicas.entity.Cita;
import com.metaenlace.gestionCitasMedicas.repository.ICitaRepository;
import com.metaenlace.gestionCitasMedicas.service.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	ICitaRepository citaRepository;
	
	@Override
	public List<Cita> findAll() {
		return (List<Cita>) citaRepository.findAll();
	}

	@Override
	public Optional<Cita> findById(Long id) {
		return citaRepository.findById(id);
	}

	@Override
	public Cita save(Cita cita) {
		return citaRepository.save(cita);
	}

	@Override
	public boolean delete(Long id) {
		Optional<Cita> citaOpt = citaRepository.findById(id);
		if (citaOpt.isPresent()) {
			Cita c = citaOpt.get();
			c.getMedico().removeCita(c);
			c.getPaciente().removeCita(c);
			citaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Cita update(Cita cita) {
		Optional<Cita> optCita = citaRepository.findById(cita.getId());
		if (optCita.isPresent()) {
			Cita citaUpdated = optCita.get();
			if (cita.getFechaHora() != null) citaUpdated.setFechaHora(cita.getFechaHora());
			if (cita.getMotivoCita() != null) citaUpdated.setMotivoCita(cita.getMotivoCita());
			if (cita.getPaciente() != null) citaUpdated.setPaciente(cita.getPaciente());
			if (cita.getMedico() != null) citaUpdated.setMedico(cita.getMedico());
			if (cita.getDiagnostico() != null) citaUpdated.setDiagnostico(cita.getDiagnostico());
			return citaRepository.save(citaUpdated);
		}
		return null;
	}
}
