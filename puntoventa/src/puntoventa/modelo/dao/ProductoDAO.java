package puntoventa.modelo.dao;

import java.util.ArrayList;

import puntoventa.modelo.Producto;

public class ProductoDAO extends GenericDAOImpl<Producto, Long> {
	public void persist(Producto producto){
		super.persist(producto);
	}
	
	public Producto buscarProductoPorClave(String clave){
		Producto p=null;
		try{
			p=(Producto)getEntityManager().createQuery("FROM Producto as p where p.codigo=:clave and p.eliminado=false").setParameter("clave", clave)
					.getSingleResult();
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return p;
	}
	
	public Producto buscarProductoPorNombre(String nombre){
		Producto p=null;
		
		try{
			p=(Producto)getEntityManager()
					.createQuery("FROM Producto as p where p.nombre = :nombre and eliminado=false")
					.setParameter("nombre", nombre)
					.getSingleResult();
		}catch (Exception e) {
			
		}
		return p;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Producto> buscarProductosPorNombre(String nombre){
		nombre=nombre.toLowerCase();
		String query="FROM Producto as p WHERE lcase(p.nombre) like '%"+nombre+"%' and p.eliminado=false order by p.nombre ";
		ArrayList<Producto> productos=null;
		try{
			//productos=(ArrayList<Producto>)getEntityManager().createQuery("From Producto where lcase(nombre) like '%:nombre%'")
			productos=(ArrayList<Producto>)getEntityManager()
					.createQuery(query)
					.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return productos;
	}
	
	public void eliminacion(Producto p){
		p.setEliminado(true);
		merge(p);
		
	}

}
