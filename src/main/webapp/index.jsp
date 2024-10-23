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

	<meta charset="UTF-8">
	<title>Menú principal gestión taller</title>
</head>
<body>
	<h1 align="center">Menú principal gestión taller</h1>

	<ul>
 		<li><a href="<%=request.getContextPath()%>/jsp/metodosREST/entregarBiciAlTaller.jsp">Ir a: Entregar bicicleta para reparación</a></li>
		<br>
		<li><a href="<%=request.getContextPath()%>/jsp/metodosREST/actualizarEstadoReparacion.jsp">Ir a: Modificar estado reparación</a></li>
		<br>
		<li><a href="<%=request.getContextPath()%>/jsp/metodosREST/recogerBiciCliente.jsp">Ir a: Recoger bici tras reparación</a></li>
	</ul>
	
</body>
</html>