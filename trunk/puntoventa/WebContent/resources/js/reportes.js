function abrir_ingreso_productos(){	
		$("#contenedor-principal").html(" <center><img  width='100px' height='100px' alt='loading...' src='resources/images/cargando.gif'/></center>");
		$.ajax({
			type : "POST",
			url : "reportes.do?abrir_todos_los_productos",
			data: "parametro=1",
			success : function(data) {
				$("#contenedor-principal").html(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status + " ERROR!");
			}
		});		
	
}

function abrirnuevo(){
	Winid=window.open('reportes/reporte1.jsp','Reporte','width=100%, height=100%');
}