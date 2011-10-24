function abrir_punto_venta(){		
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