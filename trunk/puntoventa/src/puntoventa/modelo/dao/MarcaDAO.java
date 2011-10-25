package puntoventa.modelo.dao;

import puntoventa.modelo.Marca;

public class MarcaDAO extends GenericDAOImpl<Marca, Long> {
	public void persist(Marca marca){
		super.persist(marca);	
	}
	
	public Marca buscarMarcaPorNombre(String normbre){
		Marca marca=null;
		try{
			marca=(Marca)getEntityManager().createQuery("FROM Marca WHERE nombreMarca=:marca").setParameter("marca", marca).getSingleResult();
		}catch(Exception e){
			
		}
		return marca;
	}

}
