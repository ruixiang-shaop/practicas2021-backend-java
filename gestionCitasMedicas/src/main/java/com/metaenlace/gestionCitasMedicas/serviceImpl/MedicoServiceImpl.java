package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Medico getRandom() {
	    Long amount = medicoRepository.count();
	    int idx = (int)(Math.random() * amount);
	    Page<Medico> medPage = medicoRepository.findAll(PageRequest.of(idx, 1));
	    Medico med = null;
	    if (medPage.hasContent()) {
	    	med = medPage.getContent().get(0);
	    }
	    return med;
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
	public Medico update(Medico med) {
		Optional<Medico> optMed = medicoRepository.findById(med.getId());
		if (optMed.isPresent()) {
			Medico medUpdated = optMed.get();
			if (med.getUsuario() != null) medUpdated.setUsuario(med.getUsuario());
			if (med.getClave() != null) medUpdated.setClave(med.getClave());
			if (med.getNombre() != null) medUpdated.setNombre(med.getNombre());
			if (med.getApellidos() != null) medUpdated.setApellidos(med.getApellidos());
			if (med.getNumColegiado() != null) medUpdated.setNumColegiado(med.getNumColegiado());
			if (med.getPacientes() != null) medUpdated.setPacientes(med.getPacientes());
			if (med.getCitas() != null) medUpdated.setCitas(med.getCitas());
			return medicoRepository.save(medUpdated);
		}
		return null;
	}
}
