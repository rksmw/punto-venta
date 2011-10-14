package puntoventa.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Marca
 *
 */
@Entity
@Table(name="marca")
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="marca_id",nullable=false)
	private long id;
	
	@Column(name="nombre_marca",nullable=false)
	private String nombreMarca;

	public Marca() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
   
}
