package puntoventa.modelo;

import java.io.Serializable;
import javax.persistence.*;

import puntoventa.modelo.dao.ProductoDAO;
import puntoventa.util.MensajesError;

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
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@OneToOne(targetEntity=Marca.class,cascade=CascadeType.ALL)
	private Marca marca;
	
	@ManyToOne(targetEntity=Departamento.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Departamento departamento;
	
	public MensajesError validarNombreYCodigo(){
		MensajesError mensajesError=new MensajesError();
		ProductoDAO productoDAO=new ProductoDAO();
		if(nombre.isEmpty()){
			mensajesError.getMensajes().add("El nombre no debe estar vacio");
		}else{
			
			if(productoDAO.buscarProductoPorNombre(nombre)!=null){
				mensajesError.getMensajes().add("El nombre del producto ya existe");
			}
		}
		
		if(codigo.isEmpty()){
			mensajesError.getMensajes().add("El codigo del producto no debe estar vacio");
		}else{
			if(productoDAO.buscarProductoPorClave(codigo)!=null){
				mensajesError.getMensajes().add("El codigo del producto ya existe");
			}
		}
		
		if(mensajesError.getMensajes().size()>0)
			mensajesError.setErrores(true);
		return mensajesError;
	}
	

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
