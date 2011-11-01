<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center_venta_busqueda  ui-widget ui-corner-all">
	<form >
		<table>
			<tr>
				<td>Nombre</td>
				<td>${producto.nombre}</td>
			</tr>
			<tr>
				<td>Marca</td>
				<td>${producto.marca.nombreMarca}</td>
			</tr>
			<tr>
				<td>Departamento</td>
				<td>${producto.departamento.nombreDepartamento}</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>
					<fmt:formatNumber value="${producto.precio}" type="currency"/>
				</td>
			</tr>
			<tr>
				<td>Existencias</td>
				<td>${producto.productoAlmacen.existencias}</td>
			</tr>
			<tr>
				<td><input type="button" value="Eliminar" onclick="javascript:eliminar()" class="ui-state-active ui-corner-all"/></td>
				<td><input type="button" value="Cancelar" onclick="javascript:cancelar_eliminar();" class="ui-state-active ui-corner-all"/></td>
			</tr>
		</table>
		<input type="hidden" name="productoid" value="${producto.id}"/>
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