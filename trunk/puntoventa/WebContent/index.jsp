<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto de Venta</title>

<link type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/posicionlogin.css" rel="stylesheet"/>


<link type="text/css" href="${pageContext.servletContext.contextPath}/resources/jquery/css/dot-luv/jquery-ui-1.8.16.custom.css" rel="stylesheet"/> 

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/js/jquery-ui-1.8.16.custom.min.js"></script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/js/jquery.ui.widget.js"></script>

<script type="text/javascript">
$(document).ready(function () {


	// Tabs
	$('#tabs').tabs();

	$('#tabs').tabs('load', 0);
	
});
</script>				
</head>
<body class="resto" background="resources/images/azul.jpg">
<div id="header">
	Inicio de sesi�n del sistema
	
</div>

<br>
<div class="left">
	<img width="220px" height="200px" src="resources/images/ts2.gif"/>
</div>	
<div id="tabs" class="center">
	<ul>
		<li><a href="#formlogin">Login</a>
	</ul>

</div>

<div id="formlogin" class="center ui-tabs ui-widget ui-widget-content ui-corner-all">
<form method="post" action="login">
	<table>
		<tr>
			<td>Usuario</td>
			<td><input type="text" name="usuario" value=""></td>
		</tr>		
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td>Puesto</td>
			<td>
				<select name="puesto" >
					<option value="cajero">Cajero</option>
					<option value="administrador">Administrador</option>
				</select>
			</td>		
		</tr>
		<tr>
			<td colspan="2">
				<center>
					<input type="submit" value="Ingresar" class="ui-state-active ui-corner-all"/>
				</center>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>