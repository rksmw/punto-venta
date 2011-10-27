package puntoventa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import puntoventa.modelo.Departamento;
import puntoventa.modelo.Marca;
import puntoventa.modelo.Producto;
import puntoventa.modelo.ProductoAlmacen;
import puntoventa.modelo.dao.DepartamentoDAO;
import puntoventa.modelo.dao.MarcaDAO;
import puntoventa.modelo.dao.ProductoAlmacenDAO;
import puntoventa.modelo.dao.ProductoDAO;
import puntoventa.util.MensajesError;

/**
 * Servlet implementation class MenuAdministrador
 */
public class MenuAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAdministrador() {
        super();
        //
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doAbrirAgregarDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		ArrayList<Departamento> departamentos=null;
		DepartamentoDAO departamentoDAO=new DepartamentoDAO();
		departamentos=(ArrayList<Departamento>)departamentoDAO.findAll();
		
		if(departamentos!=null){
			request.setAttribute("departamentos", departamentos);			
		}
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=getServletContext().getRequestDispatcher("/administrador/agregardepartamento.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doAgregarDepartamento(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String nombreDepartamento=request.getParameter("nombredepartamento");
		
		String mensajeError="";
		DepartamentoDAO departamentoDAO=new DepartamentoDAO();
		if(nombreDepartamento!=null  )
		if(!nombreDepartamento.isEmpty()){
			Departamento departamento=new Departamento();
			
			Departamento busqueda=departamentoDAO.buscarDepartamentoPorNombre(nombreDepartamento);
			if(busqueda==null){
				departamento.setNombreDepartamento(nombreDepartamento);
				departamentoDAO.persist(departamento);
			}else{
				mensajeError="El nombre de departamento ya existe";
			}
			
		}else{
			mensajeError="Debe ingresar un nombre de departamento";			
		}
		if(!mensajeError.isEmpty()){
			request.setAttribute("error", mensajeError);
		}
		ArrayList<Departamento>departamentos=null;
		ArrayList<Departamento> departamentosRecuperados=(ArrayList<Departamento>)departamentoDAO.findAll();
		if(departamentosRecuperados!=null){
			departamentos=new ArrayList<Departamento>();
			for(Iterator<Departamento> iterator=departamentosRecuperados.iterator();iterator.hasNext();){
				Departamento departamento=iterator.next();
				departamento.setProductos(null);
				departamentos.add(departamento);
			}
		}
		
		request.setAttribute("departamentos", departamentos);
		
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/agregardepartamento.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
	protected void doAbriragregarProductoPorClave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/actualizarexistencias.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doActualizarExistencias(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String existenciasRecuperadas=request.getParameter("existenciasproducto");
		String idProductoAlmacenRecuperado=request.getParameter("codigoproductoalmacen");
		
		String error="";
		
		ProductoAlmacen productoAlmacen=new ProductoAlmacenDAO().findById(new Long(idProductoAlmacenRecuperado));
		
		RequestDispatcher requestDispatcher=null;
		
		if(existenciasRecuperadas!=null){
			if(!existenciasRecuperadas.isEmpty()){
				try{
					int existencias=Integer.parseInt(existenciasRecuperadas);
					if(existencias<1){
						error="Las existencias deben ser mayor a 0";
					}else{
						productoAlmacen.setExistencias(existencias);
					}
				}catch(Exception e){
					error="El formato del numero de existencias no es correcto";
				}
			}else{
				error="Debe ingresar un numero de existencias";
			}
		}else{
			error="Debe ingresar un numero de existencias";
		}
		if(error.isEmpty()){
			new ProductoAlmacenDAO().merge(productoAlmacen);		
			String mensaje="Las existencias se han actualizado";
			request.setAttribute("mensaje", mensaje);
		}else{
			request.setAttribute("error", error);
		}
		request.setAttribute("producto", productoAlmacen);
		requestDispatcher=getServletContext().getRequestDispatcher("/administrador/ingresarexistencias.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
	protected void doBuscarProductoPorClave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codigoProducto=request.getParameter("claveproducto");
		String errores="";
		RequestDispatcher requestDispatcher=null;
		if(codigoProducto!=null){
			if(!codigoProducto.isEmpty()){
				
				ProductoAlmacenDAO productoAlmacenDAO=new ProductoAlmacenDAO();
				ProductoAlmacen producto=productoAlmacenDAO.buscarProductoAlmacenPorCodigo(codigoProducto);
				if(producto!=null){
					request.setAttribute("producto", producto);
				}else{
					errores="El producto con el código "+codigoProducto+" no existe";
				}								
			}else{
				errores="Debe ingresar un código de producto";
			}
		}else{
			errores="Debe ingresar un código de producto";
		}
		if(errores.isEmpty()){
			requestDispatcher=getServletContext().getRequestDispatcher("/administrador/ingresarexistencias.jsp");			
		}else{
			request.setAttribute("error", errores);
			requestDispatcher=getServletContext().getRequestDispatcher("/administrador/actualizarexistencias.jsp");
		}
		requestDispatcher.forward(request, response);
	}
	
	
	protected void doAbrirAgregarMarca(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		MarcaDAO marcaDAO=new MarcaDAO();
		ArrayList<Marca> marcas=(ArrayList<Marca>)marcaDAO.findAll();
		request.setAttribute("marcas", marcas);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/agregarmarca.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doGuardarMarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nuevaMarca=request.getParameter("nombremarca");
		
		String error="";
		if(nuevaMarca!=null){
			if(!nuevaMarca.isEmpty()){
				Marca marca=new Marca();
				MarcaDAO marcaDAO=new MarcaDAO();
				Marca marcaExistente=marcaDAO.buscarMarcaPorNombre(nuevaMarca);
				if(marcaExistente==null){
					marca.setNombreMarca(nuevaMarca);
					marcaDAO.persist(marca);
				}else{
					error="El nombre de la marca ya existe";
				}				
			}else{
				error="Debe ingresar un nombre para la marca";
			}
		}else{
			error="Debe ingresar un nombre para la marca";
		}
		
		if(!error.isEmpty()){
			request.setAttribute("error", error);
		}
		
		MarcaDAO marcaDAO=new MarcaDAO();
		ArrayList<Marca> marcas=(ArrayList<Marca>)marcaDAO.findAll();
		request.setAttribute("marcas", marcas);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/agregarmarca.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doAbrirAgregarNuevoProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		MarcaDAO marcaDAO=new MarcaDAO();
		DepartamentoDAO departamentoDAO=new DepartamentoDAO();
		ArrayList<Departamento>departamentos=null;
		
		ArrayList<Departamento> departamentosRecuperados=(ArrayList<Departamento>)departamentoDAO.findAll();
		if(departamentosRecuperados!=null){
			departamentos=new ArrayList<Departamento>();
			for(Iterator<Departamento>iterator=departamentosRecuperados.iterator();iterator.hasNext();){
				Departamento departamento=iterator.next();
				departamento.setProductos(null);
				departamentos.add(departamento);
			}
		}
		departamentosRecuperados=null;
		ArrayList<Marca>marcas=(ArrayList<Marca>)marcaDAO.findAll();
		
		request.setAttribute("marcas", marcas);
		request.setAttribute("departamentos", departamentos);
		
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/nuevoproducto.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doGuardarNuevoProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String nombre=request.getParameter("nombre");
		String codigo=request.getParameter("codigo");
		String marcaRecuperada=request.getParameter("marca");
		String departamentoRecuperado=request.getParameter("departamento");
		String precioRecuperado=request.getParameter("precio");
		String cantidadRecuperado=request.getParameter("cantidad");
		
		Producto producto=new Producto();
		producto.setNombre(nombre);
		producto.setCodigo(codigo);
		
		RequestDispatcher requestDispatcher=null;
		
		MensajesError errores=producto.validarNombreYCodigo();
		
		if(precioRecuperado.isEmpty()){
			errores.getMensajes().add("El precio no debe estar vacio");
		}else{
			try{
				float precio=Float.parseFloat(precioRecuperado);
				producto.setPrecio(precio);
			}catch(Exception e){
				errores.getMensajes().add("El formato del precio no es correcto");
			}
		}
		
		ProductoAlmacen productoAlmacen=new ProductoAlmacen();
		if(cantidadRecuperado.isEmpty()){
			errores.getMensajes().add("La cantidad no debe estar vacia");
		}else{
			try{
				int cantidad=Integer.parseInt(cantidadRecuperado);
				productoAlmacen.setExistencias(cantidad);
			}catch(Exception e){
				errores.getMensajes().add("El formato de la cantidad no es correcta");
			}
		}
		Marca marca=new MarcaDAO().findById(new Long(marcaRecuperada));
		if(marca==null){
			errores.getMensajes().add("Debe escoger una marca");
		}else{
			producto.setMarca(marca);
		}
		Departamento departamento=new DepartamentoDAO().findById(new Long(departamentoRecuperado));
		if(departamento==null){
			errores.getMensajes().add("Debe elegir un departamento");
		}else{
			producto.setDepartamento(departamento);
		}
		if(errores.getMensajes().size()>0){
			errores.setErrores(true);
		}
		
		if(errores.isErrores()){
			request.setAttribute("errores", errores);
			requestDispatcher=getServletContext().getRequestDispatcher("/administrador/nuevoproducto.jsp");
		}else{
			productoAlmacen.setProducto(producto);
			new ProductoAlmacenDAO().persist(productoAlmacen);
			requestDispatcher=getServletContext().getRequestDispatcher("/administrador/nuevoproducto.jsp");
		}
		
		MarcaDAO marcaDAO=new MarcaDAO();
		DepartamentoDAO departamentoDAO=new DepartamentoDAO();
		ArrayList<Departamento>departamentos=null;
		
		ArrayList<Departamento> departamentosRecuperados=(ArrayList<Departamento>)departamentoDAO.findAll();
		if(departamentosRecuperados!=null){
			departamentos=new ArrayList<Departamento>();
			for(Iterator<Departamento>iterator=departamentosRecuperados.iterator();iterator.hasNext();){
				Departamento departamento1=iterator.next();
				departamento1.setProductos(null);
				departamentos.add(departamento1);
			}
		}
		departamentosRecuperados=null;
		ArrayList<Marca>marcas=(ArrayList<Marca>)marcaDAO.findAll();
		
		request.setAttribute("marcas", marcas);
		request.setAttribute("departamentos", departamentos);
		requestDispatcher.forward(request, response);
	}
	
	protected void doAbrirEliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/buscarparaeliminar.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doBuscarEliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
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
					requestDispatcher=getServletContext().getRequestDispatcher("/administrador/eliminarproducto.jsp");
				}
				else{
					errores.getMensajes().add("El producto con el codigo "+criterio+" no se encuentra");
					request.setAttribute("errores", errores);
					requestDispatcher=getServletContext().getRequestDispatcher("/administrador/buscarparaeliminar.jsp");
				}
			}else{//Aun no ha sido realizada esta parte
				productos=productoDAO.buscarProductosPorNombre(criterio);
				if(productos!=null){
					if(!productos.isEmpty()){
						request.setAttribute("productos", productos);
						requestDispatcher=getServletContext().getRequestDispatcher("/administrador/listarparaeliminar.jsp");
					}else{
						errores.getMensajes().add("No se encontraron productos");
						request.setAttribute("errores", errores);
						requestDispatcher=getServletContext().getRequestDispatcher("/administrador/buscarparaeliminar.jsp");
					}
					
				}else{
					errores.getMensajes().add("No se encontraron productos");
					request.setAttribute("errores", errores);
					requestDispatcher=getServletContext().getRequestDispatcher("/administrador/buscarparaeliminar.jsp");
				}
			}
		}else{
			request.setAttribute("errores", errores);
			requestDispatcher=getServletContext().getRequestDispatcher("/comun/nombreocodigo.jsp");
		}
		requestDispatcher.forward(request, response);
	}
	
	protected void doEliminarProductoLista(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String productoId=request.getParameter("idproducto");
		
		RequestDispatcher requestDispatcher=null;
		MensajesError mensajes=new MensajesError();
		
		if(productoId!=null){
			if(!productoId.isEmpty()){
				Producto producto=new ProductoDAO().findById(new Long(productoId));
				request.setAttribute("producto", producto);
				requestDispatcher=getServletContext().getRequestDispatcher("/administrador/eliminarproducto.jsp");
			}else{
				mensajes.getMensajes().add("Debe elegir un producto a eliminar");
			}
		}else{
			mensajes.getMensajes().add("Debe elegir un producto a eliminar");
		}
		if(!mensajes.getMensajes().isEmpty()){
			request.setAttribute("errores", mensajes);
			requestDispatcher=getServletContext().getRequestDispatcher("/administrador/buscarparaeliminar.jsp");
		}
		
		requestDispatcher.forward(request, response);
	}
	
	protected void doAceptarEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String productoId=request.getParameter("productoid");
		Producto producto=new ProductoDAO().findById(new Long(productoId));
		new ProductoDAO().eliminacion(producto);
		request.setAttribute("producto", producto);
		String mensaje="El producto ha sido eliminado";
		request.setAttribute("mensaje", mensaje);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/eliminarproducto.jsp");
		requestDispatcher.forward(request, response);
		
	}
	/*
	 * 
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getQueryString().compareTo("agregar_departamento")==0){
			doAbrirAgregarDepartamento(request, response);
		}
		if(request.getQueryString().compareTo("guardar_departamento")==0){
			doAgregarDepartamento(request, response);
		}
		if(request.getQueryString().compareTo("buscar_producto_codigo")==0){
			doAbriragregarProductoPorClave(request, response);
		}
		if(request.getQueryString().compareTo("buscar_clave")==0){
			doBuscarProductoPorClave(request, response);
		}
		if(request.getQueryString().compareTo("agregar_marca")==0){
			doAbrirAgregarMarca(request, response);
		}
		if(request.getQueryString().compareTo("guardar_marca")==0){
			doGuardarMarca(request, response);
		}
		if(request.getQueryString().compareTo("nuevo_producto")==0){
			doAbrirAgregarNuevoProduct(request, response);
		}
		if(request.getQueryString().compareTo("guardar_nuevo_producto")==0){
			doGuardarNuevoProducto(request, response);
		}
		if(request.getQueryString().compareTo("actualizar_existencias")==0){
			doActualizarExistencias(request, response);
		}
		if(request.getQueryString().compareTo("abrir_eliminar_producto")==0){
			doAbrirEliminarProducto(request, response);
		}
		if(request.getQueryString().compareTo("buscar_eliminar_producto")==0){
			doBuscarEliminarProducto(request, response);
		}
		if(request.getQueryString().compareTo("aceptar_eliminar_producto")==0){
			doEliminarProductoLista(request, response);
		}
		if(request.getQueryString().compareTo("eliminar")==0){
			doAceptarEliminar(request, response);
		}						
	}

}
