<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />

<link href="${context}/estilos.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${context}/js/comun.js"></script>

<!DOCTYPE html>
<html>
<head>
	<style>
		body {
		    background-image: url("${context}/images/spark_piedras.jpg");
		    background-repeat:no-repeat;
		}
	</style>
	
	<meta charset="UTF-8">
	<title>Recoger bicicleta cliente</title>
</head>
<body>
	<h1 align="center">Recoger bicicleta cliente</h1>
	
	<br><br>	
	<form action="svRecogerBiciCliente" method="GET">
		<p>
			<label>Número de serie: </label>
			<input type="text" id="numSerie" class="input" alt="Número de serie" maxlength="5" name="numSerie"
					placeholder="Introduzca sólo números" onkeyup="javascript: return soloNumeros(this.value)">
			<button type="submit" class="myButton" style="margin-left: 60px">Aceptar</button>
		</p>
	</form>
	
	<br><br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>