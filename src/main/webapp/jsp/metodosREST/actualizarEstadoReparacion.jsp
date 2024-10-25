<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />
<c:set var="numSerie" value="<%=(String) request.getSession().getAttribute(&quot;numSerie&quot;)%>" />
<c:set var="estadoReparacion" value="<%=(String) request.getSession().getAttribute(&quot;estadoReparacion&quot;)%>" />

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
	
	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function(event) {
		    /*alert(estadoReparacionAsString);
		    document.getElementById("selectEstadosReparacion").value = ${estadoReparacionAsString};*/
		});
	</script>
	
	<meta charset="UTF-8">
	<title>Modificar estado reparación</title>
</head>
<body>
	<h1 align="center">Modificar estado reparación</h1>
	
	<br><br>
	
	<form id="formActualizarEstadoReparacion" action="svActualizarEstadoReparacion" method="POST">
		<table>
			<tr>
				<td>
					<p><label>Número de serie: </label></p>
				</td>
				<td>
					<input type="text" id="numSerie" class="input" alt="Número de serie" maxlength="5" name="numSerie" value="${numSerie}"
							readonly="readonly">
				</td>
			</tr>
			<tr>
				<td><p><label>Estado reparación: </label></p></td>
				<td width="40%">
					<div class="custom-select">
						<select id="selectEstadosReparacion" name="estadoReparacion">
							<option value="0" ${estadoReparacion == '0' ? 'selected=selected' : ''}>Pendiente</option>
						  	<option value="1" ${estadoReparacion == '1' ? 'selected=selected' : ''}>Finalizada</option>
						  	<option value="2" ${estadoReparacion == '2' ? 'selected=selected' : ''}>En curso</option>
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
	<a href="${context}">Volver a menú</a>
</body>
</html>