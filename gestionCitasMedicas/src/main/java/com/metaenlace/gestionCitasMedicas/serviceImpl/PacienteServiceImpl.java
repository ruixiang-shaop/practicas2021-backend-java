package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.repository.IPacienteRepository;
import com.metaenlace.gestionCitasMedicas.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	IPacienteRepository pacienteRepository;
	
	@Override
	public List<Paciente> findAll() {
		return (List<Paciente>) pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> findById(Long id) {
		return pacienteRepository.findById(id);
	}

	@Override
	public Paciente save(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public boolean delete(Long id) {
		if (pacienteRepository.findById(id).isPresent()) {
			pacienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Paciente update(Paciente pac) {
		Optional<Paciente> optPac = pacienteRepository.findById(pac.getId());
		if (optPac.isPresent()) {
			Paciente pacUpdated = optPac.get();
			if (pac.getUsuario() != null) pacUpdated.setUsuario(pac.getUsuario());
			if (pac.getClave() != null) pacUpdated.setClave(pac.getClave());
			if (pac.getNombre() != null) pacUpdated.setNombre(pac.getNombre());
			if (pac.getApellidos() != null) pacUpdated.setApellidos(pac.getApellidos());
			if (pac.getNss() != null) pacUpdated.setNss(pac.getNss());
			if (pac.getNumTarjeta() != null) pacUpdated.setNumTarjeta(pac.getNumTarjeta());
			if (pac.getTelefono() != null) pacUpdated.setTelefono(pac.getTelefono());
			if (pac.getDireccion() != null) pacUpdated.setDireccion(pac.getDireccion());
			if (pac.getMedicos() != null) pacUpdated.setMedicos(pac.getMedicos());
			if (pac.getCitas() != null) pacUpdated.setCitas(pac.getCitas());
			return pacienteRepository.save(pacUpdated);
		}
		return null;
	}
}
