package puntoventa.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Usuarui
 *
 */
@Entity

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="usuario_id")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String usuario;
	
	@Column
	private String password;
	
	@Column
	private String rol;
	
	@Column
	private String claveSupervisor;
	

	public Usuario() {
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


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getClaveSupervisor() {
		return claveSupervisor;
	}


	public void setClaveSupervisor(String claveSupervisor) {
		this.claveSupervisor = claveSupervisor;
	}
   
}
