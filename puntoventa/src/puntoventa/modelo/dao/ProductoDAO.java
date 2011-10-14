package puntoventa.modelo.dao;

import puntoventa.modelo.Producto;

public class ProductoDAO extends GenericDAOImpl<Producto, Long> {
	public void persist(Producto producto){
		super.persist(producto);
	}
	
	public Producto buscarProductoPorClave(String clave){
		Producto p=null;
		try{
			p=(Producto)getEntityManager().createQuery("FROM Producto as p where p.codigo=:clave").setParameter("clave", clave)
					.getSingleResult();
		}catch (Exception e) {

		}
		return p;
	}

}
