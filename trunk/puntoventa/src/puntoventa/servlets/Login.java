package puntoventa.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import puntoventa.modelo.Usuario;
import puntoventa.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioRequest=request.getParameter("usuario");
		String passwordRequest=request.getParameter("password");
		String puestoRequest=request.getParameter("puesto");
		
		Usuario usuario=null;
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		
		RequestDispatcher requestDispatcher=null;
		
		usuario=usuarioDAO.existeUsuario(usuarioRequest, passwordRequest, puestoRequest);
		
		
		
		if(usuario!=null){
			HttpSession session=request.getSession();
			session.setAttribute("usuario", usuario);
			if(usuario.getRol().compareTo("cajero")==0){
				requestDispatcher=getServletContext().getRequestDispatcher("/cajero/home.jsp");
				requestDispatcher.forward(request, response);
			}else{
				requestDispatcher=getServletContext().getRequestDispatcher("/administrador/home.jsp");
				requestDispatcher.forward(request, response);
			}
		}else{
			requestDispatcher=getServletContext().getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
