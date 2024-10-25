<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />

<link href="${context}/estilos.css" rel="stylesheet" type="text/css">

<link href="estilos.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
<head>

	<style>
		body {
		    background-image: url("${context}/images/spark_piedras.jpg");
		    background-repeat:no-repeat;
			background-size:cover;
		}
	</style>
	
	<script type="text/javascript">
		function submitMostrarBicisTaller() {
			document.getElementById("formObtenerBicisTaller").submit();
		}
	</script>

	<meta charset="UTF-8">
	<title>Menú principal gestión taller</title>
</head>
<body>
	<h1 align="center">Menú principal gestión taller</h1>

	<ul style="margin-left: 150px">
		<c:remove var="biciEncontrada" scope="session"/>
		<c:remove var="numSerie" scope="session"/>
		<c:remove var="estadoReparacion" scope="session"/>
		
 		<li><a href="${context}/jsp/metodosREST/entregarBiciAlTaller.jsp">Ir a: Entregar bicicleta para reparación</a></li>
		<br>
		<li><a href="${context}/jsp/metodosREST/buscarBici.jsp">Ir a: Modificar estado reparación</a></li>
		<br>
		<li><a href="${context}/jsp/metodosREST/recogerBiciCliente.jsp">Ir a: Recoger bicicleta tras reparación</a></li>
		<br>
		<form id="formObtenerBicisTaller" action="svObtenerBicisTaller" method="GET">
			<li><a onclick="submitMostrarBicisTaller()">Ir a: Mostrar bicicletas en taller</a></li>
		</form>
	</ul>
	
</body>
</html>