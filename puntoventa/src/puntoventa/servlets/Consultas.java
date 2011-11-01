package puntoventa.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import puntoventa.modelo.Departamento;
import puntoventa.modelo.Producto;
import puntoventa.modelo.dao.DepartamentoDAO;
import puntoventa.modelo.dao.ProductoDAO;
import puntoventa.util.MensajesError;

/**
 * Servlet implementation class Consultas
 */
public class Consultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultas() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doConsultarTodo(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		ArrayList<Departamento> departamentos;
		departamentos=(ArrayList<Departamento>)new DepartamentoDAO().buscarTodo();
		request.setAttribute("departamentos", departamentos);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/consultartodo.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doAbrirMostrarProducto(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/nombreocodigo.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doMostrarProducto(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String criterio=request.getParameter("criterio");
		String opcion=request.getParameter("buscarpor");
		MensajesError errores=new MensajesError();
		ProductoDAO productoDAO=new ProductoDAO();
		Producto producto=null;
		ArrayList<Producto> productos=null;
		
		RequestDispatcher requestDispatcher=null;
		
		if(criterio!=null){
			
			if(criterio.isEmpty()){
				errores.getMensajes().add("El campo de busqueda esta vacio");
			}
		}else{
			errores.getMensajes().add("El campo de busqueda esta vacio");
		}
		if(opcion!=null){			
			if(opcion.isEmpty()){
				errores.getMensajes().add("Debe elegir una opcion");
			}
		}else{
			errores.getMensajes().add("Debe elegir una opcion");
		}
		if(errores.getMensajes().size()>0)
			errores.setErrores(true);
		
		if(!errores.isErrores()){
			if(opcion.compareTo("codigo")==0){
				producto=productoDAO.buscarProductoPorClave(criterio);
				if(producto!=null){
					request.setAttribute("producto", producto);
					requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/mostrarunproducto.jsp");
				}
				else{
					errores.getMensajes().add("El producto con el codigo "+criterio+" no se encuentra");
					request.setAttribute("errores", errores);
					requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/nombreocodigo.jsp");
				}
			}else{
				productos=productoDAO.buscarProductosPorNombre(criterio);
				if(productos!=null){
					if(!productos.isEmpty()){
						request.setAttribute("productos", productos);
						requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/mostrarvariosproductos.jsp");
					}else{
						errores.getMensajes().add("No se encontraron productos");
						request.setAttribute("errores", errores);
						requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/nombreocodigo.jsp");
					}
					
				}else{
					errores.getMensajes().add("No se encontraron productos");
					request.setAttribute("errores", errores);
					requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/nombreocodigo.jsp");
				}
			}
		}else{
			request.setAttribute("errores", errores);
			requestDispatcher=getServletContext().getRequestDispatcher("/sesiones/comun/nombreocodigo.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getQueryString().compareTo("consultar_todo")==0){
			doConsultarTodo(request, response);
		}
		if(request.getQueryString().compareTo("abrir_mostrar_producto")==0){
			doAbrirMostrarProducto(request, response);
		}
		if(request.getQueryString().compareTo("mostrar_producto")==0){
			doMostrarProducto(request, response);
		}
	}

}
