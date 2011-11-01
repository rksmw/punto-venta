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
				<td>Código del producto</td>
				<td><input type="text" name="codigo" value=""></td>
			</tr>
			<tr>
				<td>Nombre del producto</td>
				<td><input type="text" name="nombre" value=""></td>
			</tr>
			<tr>
				<td>Marca</td>
				<td>
					<select name="marca">
						<c:forEach items="${marcas}" var="marca" varStatus="status">
							<option value="${marca.id}">${marca.nombreMarca}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Departamento</td>
				<td>
					<select name="departamento">
						<c:forEach items="${departamentos}" var="departamento" varStatus="status">
							<option value="${departamento.id}">${departamento.nombreDepartamento}</option>
						</c:forEach>
					</select>				
				</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>
					<input type="text" name="precio" value=""/>
				</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td>
					<input type="text" name="cantidad" value=""/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="button" value="Guardar producto" onclick="javascript:guardar_nuevo_producto()" class="ui-state-active ui-corner-all"/>
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