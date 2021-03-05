package com.metaenlace.gestionCitasMedicas.dto.medico;

import java.io.Serializable;
import java.util.Date;

import com.metaenlace.gestionCitasMedicas.dto.DiagnosticoDTO;
import com.metaenlace.gestionCitasMedicas.dto.PacienteOnlyDTO;


public class CitaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fechaHora;
	private String motivoCita;
	private PacienteOnlyDTO paciente;
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

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public PacienteOnlyDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteOnlyDTO paciente) {
		this.paciente = paciente;
	}

	public DiagnosticoDTO getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(DiagnosticoDTO diagnostico) {
		this.diagnostico = diagnostico;
	}
		
}
