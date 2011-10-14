package puntoventa.modelo.dao;

import puntoventa.modelo.Usuario;

public class UsuarioDAO extends GenericDAOImpl<Usuario, Long> {
	public void persist(Usuario usuario){
		super.persist(usuario);
	}
	public Usuario existeUsuario(String usuario, String password,String puesto){
		Usuario u=null;
		try{
			u=(Usuario)getEntityManager()
					.createQuery("FROM Usuario as u WHERE u.usuario=:usuario and u.password=:password and rol=:puesto").setParameter("usuario", usuario).
					setParameter("password", password).
					setParameter("puesto", puesto)
					.getSingleResult();
			
		}catch(Exception e){
			
		}
		return u;
	}
	

}
