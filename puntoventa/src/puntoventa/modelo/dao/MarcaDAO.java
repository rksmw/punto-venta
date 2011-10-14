package puntoventa.modelo.dao;

import puntoventa.modelo.Marca;

public class MarcaDAO extends GenericDAOImpl<Marca, Long> {
	public void persist(Marca marca){
		super.persist(marca);	
	}

}
