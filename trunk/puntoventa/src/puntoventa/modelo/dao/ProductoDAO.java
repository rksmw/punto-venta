package puntoventa.modelo.dao;

import puntoventa.modelo.Producto;

public class ProductoDAO extends GenericDAOImpl<Producto, Long> {
	public void persist(Producto producto){
		super.persist(producto);
	}

}
