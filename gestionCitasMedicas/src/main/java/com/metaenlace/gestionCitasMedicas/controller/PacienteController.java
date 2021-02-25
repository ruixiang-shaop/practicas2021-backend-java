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
import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.service.IPacienteService;

@RestController
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;
	
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/pacientes")
    @ResponseBody
    public List<PacienteDTO> getPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return pacientes.stream()
          .map(this::convertToDTO)
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
    public PacienteDTO addPaciente(@RequestBody PacienteDTO pacDTO) {
    	try {
    		Paciente pac = convertToEntity(pacDTO);
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
			pacienteService.update(pac);
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
    
    private PacienteDTO convertToDTO(Paciente pac) {
    	PacienteDTO postDto = modelMapper.map(pac, PacienteDTO.class);
        return postDto;
    }
    
    private Paciente convertToEntity(PacienteDTO pacDTO) {
    	Paciente pac = modelMapper.map(pacDTO, Paciente.class);
        return pac;
    }
}
