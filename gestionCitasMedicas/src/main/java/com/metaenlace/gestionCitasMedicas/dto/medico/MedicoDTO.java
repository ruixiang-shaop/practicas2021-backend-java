package com.metaenlace.gestionCitasMedicas.dto.medico;

import java.io.Serializable;
import java.util.Set;

import com.metaenlace.gestionCitasMedicas.dto.PacienteOnlyDTO;

public class MedicoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String apellidos;
	private String numColegiado;
	private Set<PacienteOnlyDTO> pacientes;
	private Set<CitaDTO> citas;
	
	public MedicoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Set<PacienteOnlyDTO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<PacienteOnlyDTO> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaDTO> citas) {
		this.citas = citas;
	}

}
