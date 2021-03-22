package com.metaenlace.gestionCitasMedicas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.metaenlace.gestionCitasMedicas.dto.paciente.PacienteDTO;
import com.metaenlace.gestionCitasMedicas.dto.register.PacienteRegistroDTO;
import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.service.IMedicoService;
import com.metaenlace.gestionCitasMedicas.service.IPacienteService;
import com.metaenlace.gestionCitasMedicas.utils.DtoMapper;

@RestController
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IMedicoService medicoService;

    @GetMapping("/pacientes")
    @ResponseBody
    public List<PacienteDTO> getPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return pacientes.stream()
          .map(p -> DtoMapper.pacienteToDto(p))
          .collect(Collectors.toList());
    }
    

    @GetMapping("/pacientes/{id}")
    @ResponseBody
    public PacienteDTO getPacienteById(@PathVariable Long id) {
        Optional<Paciente> pac = pacienteService.findById(id);
        if (pac.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return DtoMapper.pacienteToDto(pac.get());
    }
    
    @PostMapping("/pacientes/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PacienteDTO addPaciente(@RequestBody PacienteRegistroDTO pacRegDTO) {
    	try {
    		Paciente pac = DtoMapper.pacRegDtoToPaciente(pacRegDTO);
    		Medico med = medicoService.getRandom();
    		pac.addMedico(med);
    		med.addPaciente(pac);
    		Paciente createPac = pacienteService.save(pac);
    		return DtoMapper.pacienteToDto(createPac);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/pacientes/update")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO updatePaciente(@RequestBody PacienteDTO pacDTO) {
    	try {
			Paciente pac = DtoMapper.dtoToPaciente(pacDTO);
			pac = pacienteService.update(pac);
			if (pac == null)
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return DtoMapper.pacienteToDto(pac);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/pacientes/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePaciente(@PathVariable Long id) {
    	try {
			if (!pacienteService.delete(id))
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
}
