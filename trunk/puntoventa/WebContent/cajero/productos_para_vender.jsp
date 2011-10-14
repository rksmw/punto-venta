<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto de Venta</title>
</head>
<body>
<form method="post" action="">
<table>
	<tr>
		<td>Clave del producto</td>
		<td><input type="text" name="claveproducto" value=""></td>
		<td><input type="submit" value="Agregar"></td>
	</tr>
</table>
</form>

<form>
<table>
	<tr>
		<th>Nombre del producto</th>
		<th>Cantidad</th>
		<th>Precio</th>
	</tr>
	<tr>
		<td></td>
		<td>Total</td>
		<td>$xxx.xxx<input type="hidden" name="total" value="xxx.xxx"/></td>
	</tr>
	<tr>
		<td></td>
		<td>Efectivo</td>
		<td><input type="text" name="efectivo" value=""/></td>
	</tr>
	<tr>
		<td></td>
		<td>Cambio</td>
		<td><label id="">$XXXX</label></td>
	</tr>
	<tr></tr>
	<tr>
		<td><input type="button" value="Quitar producto"></td>
		<td></td>
		<td><input type="button" value="Cobrar"></td>
	</tr>
</table>
</form>

</body>
</html>