package com.metaenlace.gestionCitasMedicas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="USUARIO")@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public abstract class Usuario {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
	private String nombre;
    
    @Column(name = "apellidos", nullable = false)
	private String apellidos;
    
    @Column(name = "usuario", nullable = false)
	private String usuario;
    
    @Column(name = "clave", nullable = false)
	private String clave;
    
            
	protected Usuario() {
		super();
	}

	protected Usuario(String nombre, String apellidos, String usuario, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
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
}
