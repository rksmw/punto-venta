package puntoventa.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import puntoventa.modelo.Departamento;
import puntoventa.modelo.dao.DepartamentoDAO;

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
		if(nombreDepartamento!=null  )
		if(!nombreDepartamento.isEmpty()){
			Departamento departamento=new Departamento();
			DepartamentoDAO departamentoDAO=new DepartamentoDAO();
			Departamento busqueda=departamentoDAO.buscarDepartamentoPorNombre(nombreDepartamento);
			if(busqueda!=null){
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
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/administrador/agregardepartamento.jsp");
		requestDispatcher.forward(request, response);
	}

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
	}

}
