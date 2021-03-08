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

import com.metaenlace.gestionCitasMedicas.dto.DiagnosticoDTO;
import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;
import com.metaenlace.gestionCitasMedicas.service.IDiagnosticoService;
import com.metaenlace.gestionCitasMedicas.utils.DtoMapper;


@RestController
public class DiagnosticoController {
	@Autowired
	private IDiagnosticoService diagService;

    @GetMapping("/diagnosticos")
    @ResponseBody
    public List<DiagnosticoDTO> getDiagnosticos() {
        List<Diagnostico> diagnosticos = diagService.findAll();
        return diagnosticos.stream()
          .map(d -> DtoMapper.diagnosticoToDto(d))
          .collect(Collectors.toList());
    }
    
    @GetMapping("/diagnosticos/{id}")
    @ResponseBody
    public DiagnosticoDTO getDiagnosticoById(@PathVariable Long id) {
        Optional<Diagnostico> diag = diagService.findById(id);
        if (diag.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return DtoMapper.diagnosticoToDto(diag.get());
    }
    
    @PostMapping("/diagnosticos/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DiagnosticoDTO addDiagnostico(@RequestBody DiagnosticoDTO diagDTO) {
    	try {
    		Diagnostico diag = DtoMapper.dtoToDiagnostico(diagDTO);
    		Diagnostico createDiag = diagService.save(diag);
    		return DtoMapper.diagnosticoToDto(createDiag);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/diagnosticos/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiagnostico(@RequestBody DiagnosticoDTO diagDTO) {
    	try {
			Diagnostico diag = DtoMapper.dtoToDiagnostico(diagDTO);
			if (!diagService.update(diag))		
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/diagnosticos/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDiagnostico(@PathVariable Long id) {
    	try {
			if (!diagService.delete(id))
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	} catch (DataAccessException e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
    }
    

}
