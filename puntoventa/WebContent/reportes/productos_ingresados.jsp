<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page 

import="
java.io.IOException,
java.sql.Connection,
java.sql.DriverManager,
java.util.HashMap,

javax.servlet.ServletException,
javax.servlet.ServletOutputStream,
javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
net.sf.jasperreports.engine.JasperReport,
net.sf.jasperreports.engine.JasperRunManager,
net.sf.jasperreports.engine.util.JRLoader
"
%>

<%
String path=getServletContext().getRealPath("/reportes");

Connection conn;
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost/puntoventa?user=root&password=venezuela69");
	JasperReport jasperReport=(JasperReport)JRLoader.loadObject(path+"/productosagregados.jasper");
	HashMap<String,String> parametros=new HashMap<String,String>();
	parametros.put("fechaInicio", request.getParameter("fecha1"));
	parametros.put("fechaFin", request.getParameter("fecha2"));
	
	byte[] archivo=JasperRunManager.runReportToPdf(jasperReport, parametros,conn);
	//response.reset();			
	
	
	
	response.setContentType ("application/pdf");
	response.setHeader ("Content-disposition", "inline; filename=report1.pdf");
	response.setHeader ("Cache-Control", "max-age=30");
	response.setHeader ("Pragma", "No-cache");
	response.setDateHeader ("Expires", 0);
	
	response.flushBuffer();
	ServletOutputStream out1=response.getOutputStream();
	
	out1.write (archivo, 0, archivo.length);
	
	
	response.setContentLength (archivo.length);
	out.flush ();
	out.close ();
	
}catch(Exception e){
e.printStackTrace();

}
%>