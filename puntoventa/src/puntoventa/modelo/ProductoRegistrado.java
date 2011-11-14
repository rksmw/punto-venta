package puntoventa.modelo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;
import puntoventa.modelo.Producto;

/**
 * Entity implementation class for Entity: ProductoRegistrado
 *
 */
@Entity
public class ProductoRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="producto_registrado_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso=new Date();
	
	@Column(name="existencias_ingresadas")
	private Integer numeroIngresados;
	
	@OneToOne
	@JoinColumn(name="producto_agregado")
	private Producto producto;
	

	public ProductoRegistrado() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}   
	public Integer getNumeroIngresados() {
		return this.numeroIngresados;
	}

	public void setNumeroIngresados(Integer numeroIngresados) {
		this.numeroIngresados = numeroIngresados;
	}   
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
   
}
