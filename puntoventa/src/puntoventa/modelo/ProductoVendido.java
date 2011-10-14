package puntoventa.modelo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import javax.persistence.*;
import puntoventa.modelo.Producto;

/**
 * Entity implementation class for Entity: ProductoVendido
 *
 */
@Entity
@Table(name="producto_vendido")
public class ProductoVendido implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="producto_vendido_id")
	private Long id;
	
	
	@Column(name="unidades_vendidas",nullable=false)
	private Integer unidades;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="producto",nullable=false)
	private Producto producto;
	
	private static final long serialVersionUID = 1L;

	public ProductoVendido() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}   
	public Integer getUnidades() {
		return this.unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
   
}
