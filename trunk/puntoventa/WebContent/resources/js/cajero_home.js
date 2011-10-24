function abrir_punto_venta(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "menuCajero.do?abrir_punto_venta",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});	
	
}
function abrir_punto_venta1(){	
	$("#contenido").html("<img src='resources/images/cargando.gif'/>");
	  
}