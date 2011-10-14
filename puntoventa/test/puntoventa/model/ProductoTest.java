package puntoventa.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puntoventa.modelo.Departamento;
import puntoventa.modelo.Marca;
import puntoventa.modelo.Producto;
import puntoventa.modelo.dao.DepartamentoDAO;
import puntoventa.modelo.dao.MarcaDAO;
import puntoventa.modelo.dao.ProductoDAO;

public class ProductoTest {
	private ProductoDAO productoDAO;
	private DepartamentoDAO departamentoDAO;
	private MarcaDAO marcaDAO;

	@Before
	public void setUp() throws Exception {
		productoDAO=new ProductoDAO();
		departamentoDAO=new DepartamentoDAO();
		marcaDAO=new MarcaDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Marca marca1=new Marca();
		marca1.setNombreMarca("Spring air");
		Departamento departamento1=new Departamento();
		departamento1.setNombreDepartamento("Blancos");
		Producto producto=new Producto();
		producto.setDepartamento(departamento1);
		producto.setCodigo("56787");
		producto.setPrecio(34.50F);
		producto.setMarca(marca1);
		
		
		productoDAO.persist(producto);
	}

}
