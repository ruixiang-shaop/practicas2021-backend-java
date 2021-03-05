package com.metaenlace.gestionCitasMedicas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.gestionCitasMedicas.dto.LoginDTO;
import com.metaenlace.gestionCitasMedicas.dto.medico.MedicoDTO;
import com.metaenlace.gestionCitasMedicas.dto.paciente.PacienteDTO;
import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.entity.Usuario;
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
    
    @PostMapping(path="/auth")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
    	Optional<Usuario> optUsr = usuarioService.findByUsuario(login.getUsuario());
    	if (optUsr.isPresent()) {
    		Usuario usr = optUsr.get();
    		if (!usr.getClave().equals(login.getClave()))
				return new ResponseEntity<String>("La combinación de usuario y contraseña es incorrecta", HttpStatus.UNAUTHORIZED);
			if (usr instanceof Medico) {
				MedicoDTO mdto = MedicoController.convertToDTO((Medico) usr);
				return new ResponseEntity<MedicoDTO>(mdto, HttpStatus.OK);
    		} else {
				PacienteDTO pdto = PacienteController.convertToDTO((Paciente) usr);
				return new ResponseEntity<PacienteDTO>(pdto, HttpStatus.OK);
    		}
    	}
		return new ResponseEntity<String>("La combinación de usuario y contraseña es incorrecta", HttpStatus.UNAUTHORIZED);
    }
}
