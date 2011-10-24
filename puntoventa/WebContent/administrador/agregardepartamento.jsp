<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">

	<form >
		<table>
			<tr>
				<td>Ingresar nombre del nuevo departamento</td>
				<td><input type="text" name="nombredepartamento" value="" tabindex="0"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="button" value="Agregar" onclick="javascript:guardar_departamento();" class="ui-state-active ui-corner-all">
					</center>
				</td>
			</tr>
		</table>
	</form>
	
	<br/>
	<c:if test="${error==null}">
		<br/>
		${error}
		<br/>
	</c:if>
	
	<c:if test="${departamentos!=null}">
	<center>Departamentos registrados</center>
		<table>
			<tr>
				<th>Nombre de departamento</th>		
			</tr>
			<c:forEach items="${departamentos}" var="departamento">
				<tr>
					<td>${departamento.nombreDepartamento}</td>
				</tr>
			</c:forEach>
			
		</table>
	</c:if>
	
	
</div>
</body>
</html>