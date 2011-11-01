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
function eliminar_producto_lista(quitar,clave){
	
	
	$.ajax({
		type : "POST",
		url : "caja?eliminar_producto_lista",
		data: $('#envio-form').serialize()+"&idproductoeliminar="+$('#quitarlista').val(),
		success : function(data) {
			$("#contenedor-principal").html(data);
			$('#ui-dialog').remove();
			$('#supervisor').remove();
			$('#resultado').html("");
			$('div').remove('.ui-dialog');
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});
}


function cargar_dialogo_supervisor(){
	valorradio=$('input[name=quitarlista]:checked','#myForm').val();
	$.ajax({
		type : "POST",
		url : "caja?cargar_dialogo_supervisor",
		data: "quitarlistar="+valorradio,
		success : function(data) {
			$("#resultado").html(data);
			$( "#supervisor" ).dialog( "open" );
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});
}


function cobrar(){

	$.ajax({
		type : "POST",
		url : "caja?cobrar",
		data: "parameter=1",
		success : function(data) {
			$("#contenedor-principal").html(data);			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status + " ERROR!");
		}
	});
}

function openDialogSuper(){
	$( "#supervisor" ).dialog( "open" );
	}