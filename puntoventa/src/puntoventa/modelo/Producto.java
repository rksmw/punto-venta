package puntoventa.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="producto_id")
	private Long id;
	
	@Column(name="codigo",nullable=false)
	private String codigo;
	
	@Column(name="precio",nullable=false)
	private Float precio;
	
	@OneToOne(targetEntity=Marca.class,cascade=CascadeType.ALL)
	private Marca marca;
	
	@ManyToOne(targetEntity=Departamento.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Departamento departamento;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Producto() {
		super();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
   
}
