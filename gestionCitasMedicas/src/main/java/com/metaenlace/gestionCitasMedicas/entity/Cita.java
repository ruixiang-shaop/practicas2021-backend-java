package com.metaenlace.gestionCitasMedicas.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="CITA")

public class Cita {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHora", nullable = false)
	private Date fechaHora;
     
    @Column(name = "motivoCita", nullable = false)
	private String motivoCita;

    @JoinColumn(name = "fk_paciente", nullable = false)
	@ManyToOne(optional = false)
	private Paciente paciente;

    @JoinColumn(name = "fk_medico", nullable = false)
	@ManyToOne(optional = false)
	private Medico medico;

    @JoinColumn(name = "fk_diagnostico", referencedColumnName = "id")
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	private Diagnostico diagnostico;
	
		
	public Cita() {
		super();
	}

	public Cita(Date fechaHora, String motivoCita, Paciente paciente, Medico medico,
			Diagnostico diagnostico) {
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;
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
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
}
