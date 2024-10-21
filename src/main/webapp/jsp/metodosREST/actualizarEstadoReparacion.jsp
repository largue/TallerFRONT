<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="../../estilos.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar estado reparación</title>
</head>
<body>
	<h1 align="center">Modificar estado reparación</h1>
	
	<br><br>
	<form action="ServletTaller" method="GET">
		<p>
			<label>Estado reparación: </label>
			<input type="text" class="input" alt="Estado reparación" maxlength="1" name="estadoReparación"
					placeholder="Introduzca texto">
			<button type="submit" class="myButton" style="margin-left: 60px">Aceptar</button>
		</p>
	</form>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>