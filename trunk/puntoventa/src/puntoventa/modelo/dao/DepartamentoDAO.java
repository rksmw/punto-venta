package puntoventa.modelo.dao;

import puntoventa.modelo.Departamento;

public class DepartamentoDAO extends GenericDAOImpl<Departamento, Long> {
	public void persist(Departamento departamento){
		super.persist(departamento);
	}
	
	public Departamento buscarDepartamentoPorNombre(String nombre){
		Departamento departamento=null;
		try{
			departamento=(Departamento)getEntityManager().createQuery("FROM Departamento where nombreDepartamento=:nombred").setParameter("nombred", nombre).getSingleResult();
		}catch (Exception e) {
			
		}
		return departamento;
	}

}
