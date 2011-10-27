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
<div class="center_venta_lista_productos ui-tabs ui-widget ui-widget-content ui-corner-all">
	<form >
		<table>
			<tr>
				<td>Buscar...</td>
				<td><input type="text" name="criterio" value=""/></td>
			</tr>
			<tr>
				<td>Codigo: <input type="radio"  name="buscarpor" value="codigo"/></td>
				<td>Nombre: <input type="radio" name="buscarpor" value="nombre"/></td>
			</tr>
			<tr>
				<td>
					<center>
						<input type="button" value="Ok"  onclick="javascript:buscar_eliminar_producto();" class="ui-state-active ui-corner-all"/>
					</center>
				</td>
			</tr>
		</table>
	</form>
</div>

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