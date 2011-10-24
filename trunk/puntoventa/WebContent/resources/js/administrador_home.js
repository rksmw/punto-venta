function abrir_crear_departamento(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "menuAdministrador?agregar_departamento",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}

function guardar_departamento(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	alert("datos \n"+$('form').serialize());
	$.ajax({
		type : "POST",
		url : "menuAdministrador?guardar_departamento",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}