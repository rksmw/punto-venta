<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>

<link type="text/css" href="resources/css/menu.css" rel="stylesheet"/>



<link type="text/css" href="resources/jquery/css/dot-luv/jquery-ui-1.8.16.custom.css" rel="stylesheet"/> 

<script type="text/javascript" src="resources/jquery/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/jquery/js/jquery-ui-1.8.16.custom.min.js"></script>

<script type="text/javascript" src="resources/jquery/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="resources/jquery/js/jquery.ui.widget.js"></script>

<script type="text/javascript" src="resources/js/administrador_home.js"></script>
<script type="text/javascript" src="resources/js/operaciones_comunes.js"></script>
<script type="text/javascript" src="resources/js/reportes.js"></script>
<script type="text/javascript">

$(document).ready(function(){  
    
    $("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)  
  
    $("ul.topnav li span").click(function() { //When trigger is clicked...  
  
        //Following events are applied to the subnav itself (moving subnav up and down)  
        $(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click  
  
        $(this).parent().hover(function() {  
        }, function(){  
            $(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up  
        });  
  
        //Following events are applied to the trigger (Hover events for the trigger)  
        }).hover(function() {  
            $(this).addClass("subhover"); //On hover over, add class "subhover"  
        }, function(){  //On Hover Out  
            $(this).removeClass("subhover"); //On hover out, remove class "subhover"  
    });  

  
});  
</script>
</head>
<body background="resources/images/azul.jpg">
    <ul class="topnav">                   
        <li>  
        	<a href="#">** Productos **</a>  
        	<ul class="subnav">
        		<li><a href="#" onclick="javascript:abrir_crear_departamento();">Crear departamento</a></li>
        		<li><a href="#" onclick="javascript:abrir_crear_marca();">Crear marca</a></li>  
            	<li><a href="#" onclick="javascript:abrir_buscar_clave();">Actualizar existencias</a></li>  
            	<li><a href="#" onclick="javascript:abrir_nuevo_producto();">Nuevo producto</a></li>
            	<li><a href="#" onclick="javascript:abrir_eliminar_producto();">Eliminar producto</a></li>
        	</ul>  
    	</li>
        <li><a href="#">Agregar usuarios</a>
        	<ul class="subnav">
        		<li><a href="#" onclick="javascript:abrir_crear_cajero();">Agregar cajero</a></li>
        		<li><a href="#" onclick="javascript:abrir_crear_supervisor();">Agregar supervisor</a></li>
        		<li><a href="#" onclick="javascript:abrir_borrar_usuarios();">Eliminar usuarios</a></li>
        		
        	</ul>
        </li>
        
        <li>  
        	<a href="#">Consultar productos</a>  
        	<ul class="subnav">  
            	<li><a href="#" onclick="javascript:consultar_todo();">Consultar todos los productos</a></li>  
            	<li><a href="#" onclick="javascript:abrir_mostrar_producto();" >Consultar por nombre o c�digo</a></li>  
        	</ul>  
    	</li>        
    	<li>
    		<a href="#">Reportes</a>
    		<ul class="subnav">
    			<li><a href="#" onclick="javascript:abrirnuevo();">Todos los productos</a></li>
    			<li><a href="#" onclick="javascript:abrir_ingreso_productos();">Productos ingresados</a></li>
    			<li><a href="#" onclick="javascript:abrirmasvendidos();">Productos mas vendidos</a></li>
    			<li><a href="#"></a></li>
    			
    		</ul>
    	</li>
    	<li>
    		<a href="#">${usuario.nombre}</a>
    		<ul class="subnav">
    			<li><a href="#" onclick="javascript:abrir_actualizar_datos();">Editar mis datos</a></li>
    			<li><a href="#" onclick="javascript:cerrar_session();">cerrar sesi�n</a></li>
    		</ul>
    	</li>
    	
        
        <li><a href="#" onclick="javascript:home()">Inicio</a></li>
    </ul>  
<br/>
<center>
	<div id="contenedor-principal" style="position: absolute; top: 150px" ></div>
</center>
</body>
</html>