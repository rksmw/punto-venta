package puntoventa.modelo.dao;

import puntoventa.modelo.ProductoRegistrado;

public class ProductoRegistradoDAO extends GenericDAOImpl<ProductoRegistrado,Long> {
	public void persist(ProductoRegistrado productoRegistrado){
		super.persist(productoRegistrado);
	}

}
