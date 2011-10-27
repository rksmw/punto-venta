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

function abrir_buscar_clave(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?buscar_producto_codigo",
		data: "parametro=2",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}

function buscar_clave_producto(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?buscar_clave",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}

function actualizar_existencias(){
	$.ajax({
		type : "POST",
		url : "menuAdministrador?actualizar_existencias",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});			
}


function abrir_crear_marca(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "menuAdministrador?agregar_marca",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function guardar_marca(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?guardar_marca",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}


function abrir_nuevo_producto(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "menuAdministrador?nuevo_producto",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function guardar_nuevo_producto(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?guardar_nuevo_producto",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}

function abrir_eliminar_producto(){	
	$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
	$.ajax({
		type : "POST",
		url : "menuAdministrador?abrir_eliminar_producto",
		data: "parametro=1",
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}


function buscar_eliminar_producto(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?buscar_eliminar_producto",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}


function aceptar_eliminar(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?buscar_eliminar_producto",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function cancelar_eliminar(){		
	$("#contenedor-principal").html("");
}


function aceptar_eliminar_producto(){		
	$.ajax({
		type : "POST",
		url : "menuAdministrador?aceptar_eliminar_producto",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}
function eliminar(){
	$.ajax({
		type : "POST",
		url : "menuAdministrador?eliminar",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});
}