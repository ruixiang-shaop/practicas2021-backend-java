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
	public String update(Paciente pac) {
		if (pacienteRepository.findById(pac.getId()).isPresent()) {
			Paciente pacUpdated = new Paciente();
			pacUpdated.setId(pac.getId());
			pacUpdated.setUsuario(pac.getUsuario());
			pacUpdated.setClave(pac.getClave());
			pacUpdated.setNombre(pac.getNombre());
			pacUpdated.setApellidos(pac.getApellidos());
			pacUpdated.setNss(pac.getNss());
			pacUpdated.setNumTarjeta(pac.getNumTarjeta());
			pacUpdated.setTelefono(pac.getTelefono());
			pacUpdated.setDireccion(pac.getDireccion());
			pacUpdated.setMedicos(pac.getMedicos());
			pacUpdated.setCitas(pac.getCitas());
			pacienteRepository.save(pacUpdated);
			return "Paciente modificado";
		}
		return "Error al modificar el paciente";
	}
}
