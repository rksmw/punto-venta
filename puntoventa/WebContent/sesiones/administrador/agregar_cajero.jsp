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

<div class="ui-widget-header ui-widget ui-corner-all">
<center>
	<h2>Agregar a un cajero</h2>
</center>
	<form>
		<table>
			<tr>
				<td>Nombre del Cajero</td>
				<td><input type="text" name="nombrecajero" value=""/></td>
			</tr>
			<tr>
				<td>Nombre de usuario</td>
				<td><input type="text" name="nombreusuario" value=""/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password1" value=""/></td>
			</tr>
			<tr>
				<td>Repetir password</td>
				<td><input type="password" name="password2" value=""/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Guardar" onclick="javascript:crear_cajero();" >
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

<c:if test="${errores!=null}">
		<c:forEach items="${errores.mensajes}" var="error" varStatus="status">
			<div class="ui-widget">
				<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;"> 
					<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
						<strong>Cuidado:</strong> ${error}
					</p>
				</div>
			</div>
	</c:forEach>
	</c:if>
</body>
</html>