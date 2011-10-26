function consultar_todo(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "consultas.do?consultar_todo",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function abrir_mostrar_producto(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "consultas.do?abrir_mostrar_producto",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function mostrar_producto(){		
	$.ajax({
		type : "POST",
		url : "consultas.do?mostrar_producto",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
