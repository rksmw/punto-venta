<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {	

	// Datepicker
	$('#fecha1').datepicker({
		changeYear: true,
		changeMonth: true,
		yearRange: '1970:2020',
		dateFormat: 'yy-mm-dd',
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Mmiercoles', 'Jueves', 'Viernes', 'Sabado'],
		monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic']
	});
	$('#fecha2').datepicker({
	//inicioestudios
		changeYear: true,
		changeMonth: true,
		dateFormat: 'yy-mm-dd',
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Mmiercoles', 'Jueves', 'Viernes', 'Sabado'],
		monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic']
	});

});

</script>
</head>
<body>
<div class="center_venta_busqueda ui-widget-header ui-widget ui-corner-all">
<center><h1>Seleccione un periodo de registro de productos</h1></center>
<form method="post" action="reportes/productos_ingresados.jsp" target="_blank">

	<table>
		<tr>
			<td>Fecha incio del periodo</td>
			<td>
				<input type="text" name="fecha1" id="fecha1" />
			</td>
		</tr>
		<tr>
			<td>fecha fin del periodo</td>
			<td>
				<input type="text" name="fecha2" id="fecha2" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Consultar" class="ui-state-active ui-corner-all"> 
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>