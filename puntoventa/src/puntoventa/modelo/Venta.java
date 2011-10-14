package puntoventa.modelo;

import java.io.Serializable;
import java.lang.Long;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Venta
 *
 */
@Entity

public class Venta implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="venta_id")
	private Long id;
	
	
	private ArrayList<ProductoVendido> listaProductos=new ArrayList<ProductoVendido>();
	//TODO terminar esta relacion
	
	private static final long serialVersionUID = 1L;

	public Venta() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
