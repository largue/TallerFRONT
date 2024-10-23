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
	<title>Entregar bicicleta para reparación</title>
</head>
<body>
	<h1 align="center">Entregar bicicleta para reparación</h1>
	
	<br><br>
	<form action="svEntregarBiciAlTaller" method="POST">
		<p>
			<label>Color: </label>
			<input type="text" class="input" title="Color" name="color" style="width: 35%"
					placeholder="Introduzca texto">
		</p>
	
		<p>
			<label>Número de serie: </label>
			<input type="text" id="numSerie" class="input" alt="Número de serie" maxlength="5" name="numSerie"
					placeholder="Introduzca sólo números" onkeyup="javascript: return soloNumeros(this.value)">
			<button type="submit" class="myButton" style="margin-left: 60px">Aceptar</button>
		</p>
	</form>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>