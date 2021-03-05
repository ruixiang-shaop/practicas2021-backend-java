package com.metaenlace.gestionCitasMedicas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.metaenlace.gestionCitasMedicas.dto.PacienteDTO;
import com.metaenlace.gestionCitasMedicas.dto.PacienteRegistroDTO;
import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.service.IPacienteService;

@RestController
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;
	
    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/pacientes")
    @ResponseBody
    public List<PacienteDTO> getPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return pacientes.stream()
          .map(p -> PacienteController.convertToDTO(p))
          .collect(Collectors.toList());
    }
    

    @GetMapping("/pacientes/{id}")
    @ResponseBody
    public PacienteDTO getPacienteById(@PathVariable Long id) {
        Optional<Paciente> pac = pacienteService.findById(id);
        if (pac.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return convertToDTO(pac.get());
    }
    
    @PostMapping("/pacientes/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PacienteDTO addPaciente(@RequestBody PacienteRegistroDTO pacRegDTO) {
    	try {
    		Paciente pac = convertRegistroToEntity(pacRegDTO);
    		Paciente createPac = pacienteService.save(pac);
    		return convertToDTO(createPac);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/pacientes/update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePaciente(@RequestBody PacienteDTO pacDTO) {
    	try {
			Paciente pac = convertToEntity(pacDTO);
			if (!pacienteService.update(pac))
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
    
    static PacienteDTO convertToDTO(Paciente pac) {
    	PacienteDTO postDto = modelMapper.map(pac, PacienteDTO.class);
        return postDto;
    }
    
	static Paciente convertToEntity(PacienteDTO pacDTO) {
    	Paciente pac = modelMapper.map(pacDTO, Paciente.class);
        return pac;
    }
    
    private Paciente convertRegistroToEntity(PacienteRegistroDTO pacRegDTO) {
    	Paciente pac = modelMapper.map(pacRegDTO, Paciente.class);
        return pac;
    }
}
