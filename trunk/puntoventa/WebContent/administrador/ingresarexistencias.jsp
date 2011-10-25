<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form>
			<table>
				<tr>
					<td>Codigo del producto</td>
					<td>${producto.product.codigo}</td>
				</tr>
				<tr>
					<td>Nombre del producto</td>
					<td>${producto.producto.codigo}</td>
				</tr>
				<tr>
					<td>Precio del producto</td>
					<td>${producto.producto.precio}</td>
				</tr>
				<tr>
					<td>Marca del producto</td>
					<td>${producto.producto.marca}</td>
				</tr>
				<tr>
					<td>Departamento del producto</td>
					<td>${producto.producto.departamento.nombreDepartamento}</td>
				</tr>
				<tr>
					<td>Existencias</td>
					<td><input type="text" name="existenciasproducto" value="${producto.existencias}"/></td>
				</tr>
			</table>
			<input type="hidden" name="codigoproductoalmacen" value="${producto.id}"/> 
		</form>
	</div>
</body>
</html>