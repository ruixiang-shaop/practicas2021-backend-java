package com.metaenlace.gestionCitasMedicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.gestionCitasMedicas.service.IUsuarioService;


@RestController
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	

    @PostMapping(path="/usuarios/usuarioExists", produces="text/plain")
    @ResponseBody
    public ResponseEntity<String> checkIfUsuarioExists(@RequestBody String usuario) {
    	if (usuarioService.findByUsuario(usuario).isPresent()) {
    		return new ResponseEntity<>("true", HttpStatus.OK);
    	}
		return new ResponseEntity<>("false", HttpStatus.OK);
    }
}
