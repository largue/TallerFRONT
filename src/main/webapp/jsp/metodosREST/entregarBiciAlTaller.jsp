<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="../../estilos.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entregar bicicleta para reparación</title>
</head>
<body>
	<h1 align="center">Entregar bicicleta para reparación</h1>
	
	<br><br>
	<form action="ServletTaller" method="GET">
		<p>
			<label>Color: </label>
			<input type="text" class="input" alt="Color" maxlength="5" name="color"
					placeholder="Introduzca texto">
		</p>
	
		<p>
			<label>Número de serie: </label>
			<input type="text" class="input" alt="Número de serie" maxlength="5" name="numSerie"
					placeholder="Introduzca texto">
			<button type="submit" class="myButton" style="margin-left: 60px">Aceptar</button>
		</p>
	</form>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>