package com.metaenlace.gestionCitasMedicas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DIAGNOSTICO")

public class Diagnostico {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="valoracionEspecialista", nullable = false)
	private String valoracionEspecialista;
    
    @Column(name="enfermedad", nullable = false)
	private String enfermedad;

	@OneToOne(optional = false, mappedBy = "diagnostico")
	private Cita cita;
		
	
	public Diagnostico() {
		super();
	}

	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.cita = cita;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}
	
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}
	
	public String getEnfermedad() {
		return enfermedad;
	}
	
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	public Cita getCita() {
		return cita;
	}
	
	public void setCita(Cita cita) {
		this.cita = cita;
	}
		
}
