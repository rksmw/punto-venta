package puntoventa.modelo.dao;

import puntoventa.modelo.ProductoVendido;

public class ProductoVendidoDAO extends GenericDAOImpl<ProductoVendido, Long> {
	public void persist(ProductoVendido productoVendido) {
		super.persist(productoVendido);
	}
}
