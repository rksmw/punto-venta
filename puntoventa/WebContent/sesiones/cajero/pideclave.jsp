<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	 $( "#dialog:ui-dialog" ).dialog( "destroy" );

		$( "#supervisor" ).dialog({
			autoOpen: false,
			height: 230,
			width: 383,
			modal: true,
			buttons: {
				"Aceptar": function() {				
					eliminar_producto_lista();
					$( "#supervisor" ).dialog( "close" );
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
<div id="supervisor">
	<form id="envio-form">
		<table>
			<tr>
				<td>Clave de supervisor</td>
				<td><input type="password" name="claveform" value=""/> </td>
			</tr>
		</table>
		<input type="hidden" name="idproductoeliminar" value="${productoquitar}"/>
	</form>
</div>
</body>
</html>