package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.repository.IMedicoRepository;
import com.metaenlace.gestionCitasMedicas.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService{

	@Autowired
	IMedicoRepository medicoRepository;
	
	@Override
	public List<Medico> findAll() {
		return (List<Medico>) medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> findById(Long id) {
		return medicoRepository.findById(id);
	}

	@Override
	public Medico save(Medico medico) {
		return medicoRepository.save(medico);
	}

	@Override
	public boolean delete(Long id) {
		if (medicoRepository.findById(id).isPresent()) {
			medicoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public String update(Medico med) {
		if (medicoRepository.findById(med.getId()).isPresent()) {
			Medico medUpdated = new Medico();
			medUpdated.setId(med.getId());
			medUpdated.setUsuario(med.getUsuario());
			medUpdated.setClave(med.getClave());
			medUpdated.setNombre(med.getNombre());
			medUpdated.setApellidos(med.getApellidos());
			medUpdated.setNumColegiado(med.getNumColegiado());
			medUpdated.setPacientes(med.getPacientes());
			medUpdated.setCitas(med.getCitas());
			medicoRepository.save(medUpdated);
			return "Medico modificado";
		}
		return "Error al modificar el médico";
	}
}
