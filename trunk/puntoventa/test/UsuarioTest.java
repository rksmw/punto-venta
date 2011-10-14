import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puntoventa.modelo.Usuario;
import puntoventa.modelo.dao.UsuarioDAO;


public class UsuarioTest {
	private UsuarioDAO usuarioDAO;

	@Before
	public void setUp() throws Exception {
		usuarioDAO=new UsuarioDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Usuario usuario=new Usuario();
		usuario.setNombre("Juan Perez");
		usuario.setUsuario("jupe");
		usuario.setPassword("jupe1234");
		usuario.setRol("cajero");

		usuarioDAO.persist(usuario);

		usuario=new Usuario();
		usuario.setNombre("Pedro Lopez");
		usuario.setUsuario("pelo");
		usuario.setPassword("pelo1234");
		usuario.setRol("supervisor");
		usuario.setClaveSupervisor("clave");

		usuarioDAO.persist(usuario);

		usuario=new Usuario();
		usuario.setNombre("Ana Ruiz");
		usuario.setUsuario("anru");
		usuario.setPassword("anru1234");
		usuario.setRol("Administrador");
		usuarioDAO.persist(usuario);
	}
}
