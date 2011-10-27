package puntoventa.modelo.dao;

import puntoventa.modelo.ProductoAlmacen;

public class ProductoAlmacenDAO extends GenericDAOImpl<ProductoAlmacen, Long>{
	public void persist(ProductoAlmacen productoAlmacen){
		super.persist(productoAlmacen);
	}
	
	public ProductoAlmacen buscarProductoAlmacenPorCodigo(String codigo){
		ProductoAlmacen productoAlmacen=null;
		try{
			productoAlmacen=(ProductoAlmacen)getEntityManager().createQuery("SELECT producto FROM ProductoAlmacen as producto WHERE producto.producto.codigo=:claveproducto and producto.producto.eliminado=false").setParameter("claveproducto", codigo).getSingleResult();
		}catch(Exception e){
			
		}
		return productoAlmacen;
	}
}
