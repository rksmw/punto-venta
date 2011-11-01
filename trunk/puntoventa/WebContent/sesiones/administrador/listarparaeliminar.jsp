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
		<tr class="ui-widget-header">
			<th>Eliminar</th>
			<th>Departamento</th>
			<th>Nombre</th>
			<th>Codigo</th>
			<th>Marca</th>
			<th>Precio</th>
			<th>Existencias</th>
		</tr>
		
			<c:forEach items="${productos}" var="producto" varStatus="innerStatus">
				<tr>
					<td><input type="radio" name="idproducto" value="${producto.id}"/></td>
					<td>${producto.departamento.nombreDepartamento}</td>
					<td>${producto.nombre}</td>
					<td>${producto.codigo}</td>
					<td>${producto.marca.nombreMarca}</td>
					<td><fmt:formatNumber value="${producto.precio}" type="currency"/></td>					
					<td>${producto.productoAlmacen.existencias}</td>
				</tr>
			</c:forEach>
		<tr><td colspan="7"></td></tr>		
		<tr>
			<td colspan="7">
				<center>
					<input type="button" value="Aceptar" onclick="javascript:aceptar_eliminar_producto();"/>
				</center>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>