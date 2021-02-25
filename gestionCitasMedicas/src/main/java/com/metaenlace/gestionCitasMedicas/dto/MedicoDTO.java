package com.metaenlace.gestionCitasMedicas.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;


@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id", scope = MedicoDTO.class)
public class MedicoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String usuario;
	private String clave;
	private String nombre;
	private String apellidos;
	private String numColegiado;
	private Set<PacienteDTO> pacientes;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public Set<PacienteDTO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<PacienteDTO> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaDTO> citas) {
		this.citas = citas;
	}

}
