package com.metaenlace.gestionCitasMedicas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;


@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id", scope = CitaDTO.class)
public class CitaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private LocalDateTime fechaHora;
	private String motivoCita;
	private PacienteDTO paciente;
	private MedicoDTO medico;
	private DiagnosticoDTO diagnostico;
	
	public CitaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}

	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}

	public DiagnosticoDTO getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(DiagnosticoDTO diagnostico) {
		this.diagnostico = diagnostico;
	}
		
}
