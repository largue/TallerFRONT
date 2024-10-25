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
	<title>Modificar estado reparación</title>
</head>
<body>
	<h1 align="center">Modificar estado reparación</h1>
	
	<br><br>
	<form id="formObtenerBicisTaller" action="${context}/svObtenerBicisTaller" method="GET">
		<table>
			<tr>
				<td>
					<p><label>Número de serie: </label></p>
				</td>
				<td>
					<input type="text" id="numSerie" class="input" alt="Número de serie" maxlength="5" name="numSerie" value="${numSerie}"
								placeholder="Introduzca sólo números" onkeyup="javascript: return soloNumeros(this.value)">
				</td>
				<td><button type="submit" class="myButton" style="margin-left: 90px">Buscar</button></td>
			</tr>
		</table
	</form>
	
	<br>
	<br>
	<a href="${context}">Volver a menú</a>
</body>
</html>