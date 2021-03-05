package com.metaenlace.gestionCitasMedicas.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEDICO")
public class Medico extends Usuario {
	
	@Column(name = "numColegiado", nullable = false)
	private String numColegiado;

    @JoinTable(
    		name = "MEDICO_PACIENTE",
    		joinColumns = @JoinColumn(name = "fk_medico", nullable = false),
    		inverseJoinColumns = @JoinColumn(name = "fk_paciente", nullable = false)
    )
    
    @ManyToMany(fetch = FetchType.LAZY)
	private Set<Paciente> pacientes = new HashSet<Paciente>();
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Cita> citas = new HashSet<Cita>();

        
	public Medico() {
		super();
	}

	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
	}

	public boolean addCita(Cita c) {
		return citas.add(c);
	}
	
	public boolean removeCita(Cita c) {
		return citas.remove(c);
	}
	
	public boolean addPaciente(Paciente p) {
		return pacientes.add(p);
	}
	
	public boolean removePaciente(Paciente p) {
		return pacientes.remove(p);
	}
	
	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
}
