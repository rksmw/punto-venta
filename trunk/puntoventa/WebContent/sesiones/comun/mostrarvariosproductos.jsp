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
<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">
	<table>
		<tr>
			<th>Nombre del producto</th>
			<th>Cóigo</th>
			<th>Marca</th>
			<th>Departamento</th>
			<th>Precio</th>
			<th>Existencias</th>
		</tr>
		<c:forEach items="${productos}" var="producto" varStatus="status">
			<tr>
			<td>${producto.nombre}</td>
			<td>${producto.codigo}</td>
			<td>${producto.marca.nombreMarca}</td>
			<td>${producto.departamento.nombreDepartamento}</td>
			<td>
				<fmt:formatNumber  value="${producto.precio}" type="currency">
				</fmt:formatNumber>
			</td>
			<td>${producto.productoAlmacen.existencias}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>