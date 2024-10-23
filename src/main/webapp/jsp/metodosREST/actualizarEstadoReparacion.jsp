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
	<form action="svActualizarEstadoReparacion" method="PUT">
		<table>
			<tr>
				<td><p><label>Estado reparación: </label></p></td>
				<td width="40%">
					<div class="custom-select">
						<select id="selectEstadosReparacion" name="estadoReparacion">
							<option value="">Seleccion valor</option>
							<option value="0">Pendiente</option>
						  	<option value="1">Finalizada</option>
						  	<option value="2">En curso</option>
						</select>
						<div class="select-arrow"></div>
					</div>
				</td>
				<td><button type="submit" class="myButton" style="margin-left: 60px">Aceptar</button></td>
			</tr>
		</table>
	</form>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>