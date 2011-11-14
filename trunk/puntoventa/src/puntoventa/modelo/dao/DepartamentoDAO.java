package puntoventa.modelo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import puntoventa.modelo.Departamento;
import puntoventa.modelo.Producto;

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
	
	public static Collection<Departamento> todosPorDeartamento(){
		return new DepartamentoDAO().buscarTodo();
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Departamento> buscarTodo(){
		
		ArrayList<Departamento>todo=null;
		ArrayList<Departamento>auxiliar=new ArrayList<Departamento>();
		getEntityManager().clear();
		try{
			todo=(ArrayList<Departamento>)getEntityManager()
					.createQuery("FROM Departamento dep order by dep.nombreDepartamento")
					.getResultList();
			
			for(Iterator<Departamento> iterator=todo.iterator();iterator.hasNext();){
				Departamento departamento=iterator.next();
				departamento.setProductos(null);
				List<Producto> productos=getEntityManager().createQuery("From Producto where departamento.id=:did and eliminado=false order by nombre")
						.setParameter("did", departamento.getId()).getResultList();
				refresh(departamento);
				departamento.setProductos(productos);
				auxiliar.add(departamento);
			}
			todo=auxiliar;
			
		}catch(Exception e){
			e.printStackTrace();
			todo=null;
		}
		return todo;
	}

}
