<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto de Venta</title>

<script type="text/javascript">
$(function() {
	 $('#efectivo').keypress(function(event){
		 var total=parseFloat($('#total').val());


		var ingresado=parseFloat($('#efectivo').val()+String.fromCharCode(event.charCode));

		
		var cambio=ingresado-total;
	
		$('#cambio').html("$ "+cambio.toString());
			
	});
});
</script>
</head>
<body>
<center>
	<h1>Terminal del usuario ${usuario.nombre}</h1>
</center>
<div class="ui-widget-header ui-widget ui-corner-all">
	<form method="post" action="">
	<table>
		<tr>
			<td>Clave del producto</td>
			<td><input type="text" name="claveproducto" value="" tabindex="1" ></td>
			<td><input type="button" value="Agregar" onclick="javascript:buscar_para_agregar();" class="ui-state-active ui-corner-all"></td>
		</tr>
	</table>
	</form>
</div>

<!--  <div class="center_venta_lista_productos ui-tabs ui-widget ui-widget-content ui-corner-all">  -->
<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">

<form>
<table>
	<tr>
		<th>Nombre del producto</th>
		<th>Cantidad</th>
		<th>Precio</th>
	</tr>
	<c:forEach items="${productos}" var="productoVendido" varStatus="status">
		<tr>
			<td>${productoVendido.producto.nombre}</td>
			<td>${productoVendido.unidades}</td>
			<td>
				<fmt:formatNumber value="${productoVendido.producto.precio}" type="currency" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td>Total</td>
		<td>
		<c:set var="total" value="0"></c:set>
		<c:forEach items="${productos}" var="productosVendidos" varStatus="status2">
			<c:set var="total" value="${total+(productosVendidos.producto.precio*productosVendidos.unidades)}"></c:set>
		</c:forEach>
		<input type="hidden" id="total" value="${total}"/>
		<label >
			<fmt:formatNumber value="${total}" type="currency"/>
		</label>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>Efectivo</td>
		<td><input type="text" id="efectivo" name="efectivo" value=""/></td>
	</tr>
	<tr>
		<td></td>
		<td>Cambio</td>
		<td>
			<div id="cambio">
			$ 0.0
			</div>
		</td>
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
<div id="resultado"></div>

</body>
</html>