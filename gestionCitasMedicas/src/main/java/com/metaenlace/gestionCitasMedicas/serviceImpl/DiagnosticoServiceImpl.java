package com.metaenlace.gestionCitasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;
import com.metaenlace.gestionCitasMedicas.repository.IDiagnosticoRepository;
import com.metaenlace.gestionCitasMedicas.service.IDiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements IDiagnosticoService{

	@Autowired
	IDiagnosticoRepository diagRepository;
	
	@Override
	public List<Diagnostico> findAll() {
		return (List<Diagnostico>) diagRepository.findAll();
	}

	@Override
	public Optional<Diagnostico> findById(Long id) {
		return diagRepository.findById(id);
	}

	@Override
	public Diagnostico save(Diagnostico diagnostico) {
		return diagRepository.save(diagnostico);
	}

	@Override
	public boolean delete(Long id) {
		Optional<Diagnostico> diag = diagRepository.findById(id);
		if (diag.isPresent()) {
			diag.get().getCita().setDiagnostico(null);
			diagRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Diagnostico diag) {
		Optional<Diagnostico> optDiag = diagRepository.findById(diag.getId());
		if (optDiag.isPresent()) {
			Diagnostico diagUpdated = optDiag.get();
			if (diag.getValoracionEspecialista() != null) diagUpdated.setValoracionEspecialista(diag.getValoracionEspecialista());
			if (diag.getEnfermedad() != null) diagUpdated.setEnfermedad(diag.getEnfermedad());
			diagRepository.save(diagUpdated);
			return true;
		}
		return false;
	}
}
