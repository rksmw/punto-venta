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
				<td>Ingresar nombre de la nueva marca</td>
				<td><input type="text" id="nombremarca" name="nombremarca" value="" tabindex="1"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="button" value="Agregar" onclick="javascript:guardar_marca();" class="ui-state-active ui-corner-all">
					</center>
				</td>
			</tr>
		</table>
	</form>
</div>
	
	<br/>
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
	
	<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">
	<c:if test="${marcas!=null}">
	<center>Marcas existentes</center>
		<table>

			<c:forEach items="${marcas}" var="marca" varStatus="status">
				<tr>
					<td>${marca.nombreMarca}</td>
				</tr>
			</c:forEach>
			
		</table>
	</c:if>
</div>	

</body>
</html>