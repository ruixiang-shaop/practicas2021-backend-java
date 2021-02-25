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

import com.metaenlace.gestionCitasMedicas.dto.MedicoDTO;
import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.service.IMedicoService;

@RestController
public class MedicoController {
	@Autowired
	private IMedicoService medicoService;
	
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/medicos")
    @ResponseBody
    public List<MedicoDTO> getMedicos() {
        List<Medico> medicos = medicoService.findAll();
        return medicos.stream()
          .map(this::convertToDTO)
          .collect(Collectors.toList());
    }
    
    @GetMapping("/medicos/{id}")
    @ResponseBody
    public MedicoDTO getMedicoById(@PathVariable Long id) {
        Optional<Medico> med = medicoService.findById(id);
        if (med.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return convertToDTO(med.get());
    }
    
    @PostMapping("/medicos/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MedicoDTO addMedico(@RequestBody MedicoDTO medDTO) {
    	try {
    		Medico med = convertToEntity(medDTO);
    		Medico createMed = medicoService.save(med);
    		return convertToDTO(createMed);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/medicos/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateMedico(@RequestBody MedicoDTO medDTO) {
    	try {
			Medico med = convertToEntity(medDTO);
			medicoService.update(med);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping(value = "/medicos/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMedico(@PathVariable Long id) {
    	try {
			if (!medicoService.delete(id))
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    private MedicoDTO convertToDTO(Medico med) {
    	MedicoDTO postDto = modelMapper.map(med, MedicoDTO.class);
        return postDto;
    }
    
    private Medico convertToEntity(MedicoDTO medDTO) {
    	Medico med = modelMapper.map(medDTO, Medico.class);
        return med;
    }
}