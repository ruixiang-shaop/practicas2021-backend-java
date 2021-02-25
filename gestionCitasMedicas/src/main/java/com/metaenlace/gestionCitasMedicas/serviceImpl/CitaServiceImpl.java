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
	public String update(Cita cita) {
		if (citaRepository.findById(cita.getId()).isPresent()) {
			Cita citaUpdated = new Cita();
			citaUpdated.setId(cita.getId());
			citaUpdated.setFechaHora(cita.getFechaHora());
			citaUpdated.setMotivoCita(cita.getMotivoCita());
			citaUpdated.setPaciente(cita.getPaciente());
			citaUpdated.setMedico(cita.getMedico());
			citaUpdated.setDiagnostico(cita.getDiagnostico());
			citaRepository.save(citaUpdated);
			return "Cita modificada";
		}
		return "Error al modificar la cita";
	}
}
