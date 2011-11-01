package puntoventa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import puntoventa.modelo.Producto;
import puntoventa.modelo.ProductoVendido;
import puntoventa.modelo.Usuario;
import puntoventa.modelo.dao.ProductoDAO;
import puntoventa.modelo.dao.UsuarioDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doAgregarProducto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cantidadProductoRequest = request.getParameter("cantidad");
		String codigoProductoRequest = request.getParameter("productoid");

		Producto producto = null;
		ProductoDAO productoDAO = new ProductoDAO();
		String mensaje = "";

		RequestDispatcher requestDispatcher = null;

		if (cantidadProductoRequest != null) {
			try {
				int cantidad = Integer.parseInt(cantidadProductoRequest);
				producto = productoDAO
						.findById(new Long(codigoProductoRequest));

				if (producto.getProductoAlmacen().getExistencias() - cantidad < 10) {
					mensaje = "el numero de existencias de este producto esta or agotarse";
				}
				if (producto.getProductoAlmacen().getExistencias() - cantidad > 0) {
					ProductoVendido productoVendido = new ProductoVendido();
					productoVendido.setProducto(producto);
					productoVendido.setUnidades(cantidad);
					productoVendido.setFechaCompra(new Date());

					HttpSession session = request.getSession();
					ArrayList<ProductoVendido> productos = null;
					if (session.getAttribute("productos") == null) {
						productos = new ArrayList<ProductoVendido>();
					} else {
						productos = (ArrayList<ProductoVendido>) session
								.getAttribute("productos");
						session.removeAttribute("productos");
					}
					productos.add(productoVendido);
					session.setAttribute("productos", productos);
				}
			} catch (Exception e) {
			}
		} else {
			mensaje = "Verifique la informacion porfavor";
			request.setAttribute("mensaje", mensaje);
		}
		requestDispatcher = getServletContext().getRequestDispatcher(
				"/cajero/productos_para_vender.jsp");
		requestDispatcher.forward(request, response);

		/*
		 * ArrayList<Producto> listaCompras=null;
		 * 
		 * if(producto!=null){ HttpSession sesion=request.getSession();
		 * if(sesion.getAttribute("listacompras")==null){ listaCompras=new
		 * ArrayList<Producto>(); }else{
		 * listaCompras=(ArrayList<Producto>)sesion
		 * .getAttribute("listacompras"); listaCompras.add(producto); } }
		 */
	}

	protected void doBuscarParaAgregar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String codigoProducto = request.getParameter("claveproducto");
		Producto producto = new ProductoDAO()
				.buscarProductoPorClave(codigoProducto);
		RequestDispatcher requestDispatcher = null;
		if (producto != null) {
			request.setAttribute("producto", producto);
			requestDispatcher = getServletContext().getRequestDispatcher(
					"/cajero/productos.jsp");
		} else {
			requestDispatcher = getServletContext().getRequestDispatcher(
					"/cajero/noencontrado.jsp");
		}
		requestDispatcher.forward(request, response);
	}


	protected void doEliminarDeLista(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String clave = request.getParameter("claveform");
		Usuario u = null;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		u = usuarioDAO.obtenerUsuarioPorClave(clave);
		String idEliminar = request.getParameter("idproductoeliminar");
		if (u != null) {

			if (idEliminar != null) {
				Long eliminar = new Long(idEliminar);
				HttpSession session = request.getSession();
				if (session.getAttribute("productos") != null) {
					@SuppressWarnings("unchecked")
					ArrayList<ProductoVendido> productos = (ArrayList<ProductoVendido>) session
							.getAttribute("productos");
					productos.remove((int)eliminar.intValue());
					session.removeAttribute("productos");
					session.setAttribute("productos", productos);
				}
			}
		}
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/cajero/productos_para_vender.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doCargarDialogoAdministrador(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		String quitar=request.getParameter("quitarlistar");
		request.setAttribute("productoquitar",quitar);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/cajero/pideclave.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString().compareTo("buscar_para_agregar") == 0) {
			doBuscarParaAgregar(request, response);
		}
		if (request.getQueryString().compareTo("agregar_producto_lista") == 0) {
			doAgregarProducto(request, response);
		}
		if (request.getQueryString().compareTo("eliminar_producto_lista") == 0) {
			doEliminarDeLista(request, response);
		}
		if (request.getQueryString().compareTo("cargar_dialogo_supervisor") == 0) {
			doCargarDialogoAdministrador(request, response);
		}
		
	}

}
