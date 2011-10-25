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
				<td>Ingresar codigo del producto</td>
				<td><input type="text" name="claveproducto" value=""/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Buscar" onclick="javascript:buscar_clave_producto();"/>
				</td>
			</tr>
		</table>
	</form>
	<br/>	
</div>
	<c:if test="${error!=null}">
		<br/>
		<div class="ui-widget">
			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;"> 
				<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span> 
				<strong>Cuidado:</strong> ${error}</p>
			</div>
		</div>
		
		
		<br/>
	</c:if>
</body>
</html>