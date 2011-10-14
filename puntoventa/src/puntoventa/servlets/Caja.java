package puntoventa.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import puntoventa.modelo.Producto;
import puntoventa.modelo.dao.ProductoDAO;

/**
 * Servlet implementation class Caja
 */
public class Caja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Caja() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	@SuppressWarnings("unchecked")
	protected void doAgregarProducto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String claveProductoRequest=request.getParameter("claveproducto");
		Producto producto=null;
		ProductoDAO productoDAO=new ProductoDAO();
		
		producto=productoDAO.buscarProductoPorClave(claveProductoRequest);
		
		ArrayList<Producto> listaCompras=null;
		
		if(producto!=null){
			HttpSession sesion=request.getSession();
			if(sesion.getAttribute("listacompras")==null){
				listaCompras=new ArrayList<Producto>();
			}else{
				listaCompras=(ArrayList<Producto>)sesion.getAttribute("listacompras");
				listaCompras.add(producto);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
