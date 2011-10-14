package puntoventa.modelo.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  Clase que implementa el patron de disenio Data Access Object
 * @author rene lopez
 *
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDAOImpl<T,ID extends Serializable> implements GenericDAO<T, ID> {
	
	protected static Logger logger = Logger.getLogger(GenericDAOImpl.class);
    static{logger.setLevel(Level.DEBUG);}
    
	private Class<T> entityBeanType;

    private static EntityManager entityManager;
    
    static{
		EntityManagerFactory emf;        	
		emf 	= Persistence.createEntityManagerFactory("puntoventaJPA");   	    	
    	entityManager = emf.createEntityManager();
    	entityTransaction = entityManager.getTransaction();
	}
    
    private static EntityTransaction entityTransaction;
    
    @SuppressWarnings("unchecked")
	public GenericDAOImpl(){    	
    	this.entityBeanType = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    /*@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
        entityTransaction = getEntityManager().getTransaction();
    }*/

    public EntityManager getEntityManager() {
        if (entityManager == null)
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        return entityManager;
    }
    
    public Class<T> getEntityBeanType() {
        return entityBeanType;
    }

    public T findById(ID id) {
    	T entityResult =null;
    	try{
    	entityTransaction.begin();
    	getEntityManager().flush();    	
    	entityResult = getEntityManager().find(entityBeanType, id);    	
    	getEntityManager().refresh(entityResult);
    	entityTransaction.commit();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
        return entityResult;
        
    }
    

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + getEntityBeanType().getName() ).getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        // Using Hibernate, more difficult with EntityManager and EJB-QL
        org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager)getEntityManager())
                            .getSession()
                            .createCriteria(getEntityBeanType());
        org.hibernate.criterion.Example example =
                org.hibernate.criterion.Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    
    
    public void persist(T entity) {    	
		entityTransaction.begin();
        getEntityManager().persist(entity);
        entityTransaction.commit();        
    }
    
    public void merge(T entity) {
		entityTransaction.begin();
        getEntityManager().merge(entity);
        entityTransaction.commit();
    }
    
    public void remove(T entity) {
    	entityTransaction.begin();
    	getEntityManager().remove(entity);
    	entityTransaction.commit();
    }
    
    public void refresh(T oldEntity) {
    	getEntityManager().refresh(oldEntity);
    }

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		GenericDAOImpl.logger = logger;
	}

}
