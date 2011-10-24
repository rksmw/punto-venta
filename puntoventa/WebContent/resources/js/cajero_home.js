function abrir_punto_venta(){	
	$("#contenido").html("<img src='resources/images/cargando.gif'/>");
	
}
function abrir_punto_venta1(){	
	$("#contenido").html("<img src='resources/images/cargando.gif'/>");
	$.ajax({
		type : "POST",
		url : "menuCajero.do?abrir_punto_venta",
		data: "parametro=1",
		success : function(data) {
			$("#contenido").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		  
}