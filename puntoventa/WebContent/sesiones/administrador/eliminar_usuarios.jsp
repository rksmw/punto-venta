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
<div class="ui-tabs ui-widget ui-widget-content ui-corner-all">
	<form>
		<table>
			<tr>
				<th>Eliminar</th>
				<th>Nombre</th>
				<th>Nombre de usuario</th>
				<th>Rol</th>
			</tr>
		<c:forEach items="${usuarios}" var="usuario" varStatus="status">
		<tr>
				<td><input type="radio" name="usuarioeliminar" value="${usuario.id}"/></td>
				<td>${usuario.nombre}</td>
				<td>${usuario.usuario}</td>
				<td>${usuario.rol}</td>
			</tr>	
		</c:forEach>			
		<tr>
			<td colspan="2">
				<input type="button" value="Eliminar" onclick="javascript:eliminar_este_usuario();" >
			</td>
		</tr>	
		</table>
	</form>
</div>
<c:if test="${mensaje!=null}">	
	<div class="ui-widget">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;"> 
				<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				<strong>Hey!</strong> ${mensaje}.</p>
			</div>
		</div>
</c:if>	
</body>
</html>