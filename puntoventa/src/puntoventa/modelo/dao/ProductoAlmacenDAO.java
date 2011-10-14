package puntoventa.modelo.dao;

import puntoventa.modelo.ProductoAlmacen;

public class ProductoAlmacenDAO extends GenericDAOImpl<ProductoAlmacen, Long>{
	public void persist(ProductoAlmacen productoAlmacen){
		super.persist(productoAlmacen);
	}
}
