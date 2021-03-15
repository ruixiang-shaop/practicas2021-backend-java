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

import com.metaenlace.gestionCitasMedicas.dto.cita.CitaDTO;
import com.metaenlace.gestionCitasMedicas.entity.Cita;
import com.metaenlace.gestionCitasMedicas.service.ICitaService;
import com.metaenlace.gestionCitasMedicas.utils.DtoMapper;


@RestController
public class CitaController {
	@Autowired
	private ICitaService citaService;

    @GetMapping("/citas")
    @ResponseBody
    public List<CitaDTO> getCitas() {
        List<Cita> citas = citaService.findAll();
        return citas.stream()
          .map(c -> DtoMapper.citaToDto(c))
          .collect(Collectors.toList());
    }
    
    @GetMapping("/citas/{id}")
    @ResponseBody
    public CitaDTO getCitaById(@PathVariable Long id) {
        Optional<Cita> cita = citaService.findById(id);
        if (cita.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return DtoMapper.citaToDto(cita.get());
    }
    
    @PostMapping("/citas/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CitaDTO addCita(@RequestBody CitaDTO citaDTO) {
    	try {
    		Cita cita = DtoMapper.dtoToCita(citaDTO);
    		Cita createCita = citaService.save(cita);
    		return DtoMapper.citaToDto(createCita);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/citas/update")
    @ResponseStatus(HttpStatus.OK)
    public CitaDTO updateCita(@RequestBody CitaDTO citaDTO) {
    	try {
			Cita cita = DtoMapper.dtoToCita(citaDTO);
			cita = citaService.update(cita);
			if (cita == null)
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return DtoMapper.citaToDto(cita);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/citas/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCita(@PathVariable Long id) {
    	try {
			if (!citaService.delete(id))
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
}
