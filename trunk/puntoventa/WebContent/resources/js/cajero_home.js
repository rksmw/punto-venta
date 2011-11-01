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

function buscar_para_agregar(){	

	$.ajax({
		type : "POST",
		url : "caja?buscar_para_agregar",
		data: $('form').serialize(),
		success : function(data) {
			$("#resultado").html(data);
			$( "#dialog-form" ).dialog( "open" );			
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}


function agregar_producto_lista(){	
	
	$.ajax({
		type : "POST",
		url : "caja?agregar_producto_lista",
		data: $('form').serialize(),
		success : function(data) {
			$("#contenedor-principal").html("");
			$("#contenedor-principal").html(data);
			$('#ui-dialog').remove();
			$('#dialog-form').remove();
			$('#resultado').html("");
			$('div').remove('.ui-dialog');
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});		
}

