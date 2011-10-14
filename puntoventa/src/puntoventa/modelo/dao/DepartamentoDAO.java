package puntoventa.modelo.dao;

import puntoventa.modelo.Departamento;

public class DepartamentoDAO extends GenericDAOImpl<Departamento, Long> {
	public void persist(Departamento departamento){
		super.persist(departamento);
	}

}
