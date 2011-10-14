package puntoventa.modelo;

import java.io.Serializable; 
import java.lang.Integer;
import java.lang.Long;
import javax.persistence.*;
import puntoventa.modelo.Producto;

/**
 * Entity implementation class for Entity: ProductoAlmacen
 *
 */
@Entity
@Table(name="producto_almacen")
public class ProductoAlmacen implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="producto_almacen_id")
	private Long id;
	
	@Column(name="producto",nullable=false)
	private Producto producto;
	
	@Column(name="cantidad_producto",nullable=false)
	private Integer existencias;
	
	private static final long serialVersionUID = 1L;

	public ProductoAlmacen() {
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
	public Integer getExistencias() {
		return this.existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
   
}
