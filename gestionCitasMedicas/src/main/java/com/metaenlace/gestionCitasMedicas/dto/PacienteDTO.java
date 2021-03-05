package com.metaenlace.gestionCitasMedicas.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id", scope = PacienteDTO.class)
public class PacienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String apellidos;
	private String nss;
	private String numTarjeta;
	private String telefono;
	private String direccion;
	private Set<MedicoDTO> medicos;
	private Set<CitaDTO> citas;
		
	public PacienteDTO() {
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

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<MedicoDTO> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<MedicoDTO> medicos) {
		this.medicos = medicos;
	}

	public Set<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaDTO> citas) {
		this.citas = citas;
	}

}
