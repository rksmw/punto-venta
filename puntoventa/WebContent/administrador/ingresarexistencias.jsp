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
	<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">
		<form>
			<table>
				<tr>
					<td>Codigo del producto</td>
					<td>${producto.producto.codigo}</td>
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
					<td>${producto.producto.marca.nombreMarca}</td>
				</tr>
				<tr>
					<td>Departamento del producto</td>
					<td>${producto.producto.departamento.nombreDepartamento}</td>
				</tr>
				<tr>
					<td>Existencias</td>
					<td><input type="text" name="existenciasproducto" value="${producto.existencias}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="button" value="Actualizar" onclick="javascritp:actualizar_existencias();" class="ui-state-active ui-corner-all"/>
						</center>
					</td>
				</tr>
			</table>
			<input type="hidden" name="codigoproductoalmacen" value="${producto.id}"/> 
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
	<c:if test="${error!=null}">
		<div class="ui-widget">
			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;"> 
				<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span> 
				<strong>Cuidado:</strong> ${error}</p>
			</div>
		</div>					
	</c:if>
</body>
</html>