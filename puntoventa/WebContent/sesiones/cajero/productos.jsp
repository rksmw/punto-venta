<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
	$( "#dialog:ui-dialog" ).dialog( "destroy" );

	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 330,
		width: 683,
		modal: true,
		buttons: {
			"Aceptar": function() {				
				agregar_producto_lista();
				$( "#dialog-form" ).dialog( "close" );
			},
			Cancel: function() {
				$( this ).dialog( "close" );
			}
		},
		close: function() {
			//allFields.val( "" ).removeClass( "ui-state-error" );
		}
	});


});
</script>
</head>
<body>
<div id="dialog-form" title="Agregar producto">		
	<form>
		<table>
			<tr>
				<td>Nombre del Producto</td>
				<td>${producto.nombre}</td>
			</tr>
			<tr>
				<td>Departamento</td>
				<td>${producto.departamento.nombreDepartamento}</td>
			</tr>
			<tr>
				<td>Marca</td>
				<td>${producto.marca.nombreMarca}</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>
					<fmt:formatNumber value="${producto.precio}" type="currency"/>					
				</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td><input type="text" name="cantidad" id="cantidad" value="1" size="3" class="text ui-widget-content ui-corner-all" /></td>
			</tr>
		</table>
		<input type="hidden" name="productoid" value="${producto.id}"/> 
	</form>
</div>	
</body>
</html>
