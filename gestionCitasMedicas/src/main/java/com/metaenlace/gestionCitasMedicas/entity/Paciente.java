package com.metaenlace.gestionCitasMedicas.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PACIENTE")
public class Paciente extends Usuario {
    
    @Column(name = "nss", nullable = false)
	private String nss;
    
    @Column(name = "numTarjeta", nullable = false)
	private String numTarjeta;
    
    @Column(name = "telefono", nullable = false)
	private String telefono;
    
    @Column(name = "direccion", nullable = false)
	private String direccion;
    
    @ManyToMany(mappedBy = "pacientes", fetch = FetchType.EAGER)
	private Set<Medico> medicos = new HashSet<Medico>();
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Cita> citas = new HashSet<Cita>();
	
			
	public Paciente() {
		super();
	}

	public Paciente(String nombre, String apellidos, String usuario, String clave, String nss, String numTarjeta,
			String telefono, String direccion) {
		super(nombre, apellidos, usuario, clave);
		this.nss = nss;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public boolean addCita(Cita c) {
		return citas.add(c);
	}
	
	public boolean addMedico(Medico m) {
		return medicos.add(m);
	}
	
	public boolean removeCita(Cita c) {
		return citas.remove(c);
	}
	
	public boolean removeMedico(Medico m) {
		return medicos.remove(m);
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
	
	public Set<Medico> getMedicos() {
		return medicos;
	}
	
	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}
	
	public Set<Cita> getCitas() {
		return citas;
	}
	
	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	
}
