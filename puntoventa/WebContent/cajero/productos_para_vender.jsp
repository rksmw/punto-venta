<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto de Venta</title>
<link type="text/css" href="resources/css/posicionlogin.css" rel="stylesheet"/>


<link type="text/css" href="resources/jquery/css/dot-luv/jquery-ui-1.8.16.custom.css" rel="stylesheet"/> 

<script type="text/javascript" src="resources/jquery/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/jquery/js/jquery-ui-1.8.16.custom.min.js"></script>

<script type="text/javascript" src="resources/jquery/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="resources/jquery/js/jquery.ui.widget.js"></script>
</head>
<body>
<center>
	<h1>Terminal del usuario ${usuario.nombre}</h1>
</center>
<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">
	<form method="post" action="">
	<table>
		<tr>
			<td>Clave del producto</td>
			<td><input type="text" name="claveproducto" value="" tabindex="1" ></td>
			<td><input type="submit" value="Agregar" class="ui-state-active ui-corner-all"></td>
		</tr>
	</table>
	</form>
</div>
<div class="center_venta_lista_productos ui-tabs ui-widget ui-widget-content ui-corner-all">
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
		<td><input type="button" value="Quitar producto" class="ui-state-active ui-corner-all"></td>
		<td></td>
		<td><input type="button" value="Cobrar" class="ui-state-active ui-corner-all"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>