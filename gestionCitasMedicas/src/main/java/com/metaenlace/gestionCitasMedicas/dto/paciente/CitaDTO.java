package com.metaenlace.gestionCitasMedicas.dto.paciente;

import java.io.Serializable;
import java.util.Date;

import com.metaenlace.gestionCitasMedicas.dto.DiagnosticoOnlyDTO;
import com.metaenlace.gestionCitasMedicas.dto.MedicoOnlyDTO;


public class CitaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fechaHora;
	private String motivoCita;
	private MedicoOnlyDTO medico;
	private DiagnosticoOnlyDTO diagnostico;
	
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

	public MedicoOnlyDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoOnlyDTO medico) {
		this.medico = medico;
	}

	public DiagnosticoOnlyDTO getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(DiagnosticoOnlyDTO diagnostico) {
		this.diagnostico = diagnostico;
	}
		
}
