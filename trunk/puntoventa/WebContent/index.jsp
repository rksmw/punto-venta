<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto de Venta</title>
</head>
<body>
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
			<td colspan="2"><input type="submit" value="Ingresar"></td>
		</tr>
	</table>
</form>
</body>
</html>