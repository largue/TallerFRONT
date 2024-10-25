<%@page import="java.util.List"%>
<%@page import="com.example.tallerrest.model.BicicletaDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />

<c:set var="listaBicis" value="<%=(List) request.getSession().getAttribute(&quot;listaBicis&quot;)%>" />

<link href="${context}/estilos.css" rel="stylesheet" type="text/css">

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
	<title>Bicicletas en el taller</title>
</head>
<body>
	<h1 align="center">Bicicletas en el taller</h1>
	
	<c:forEach items="${listaBicis}" var="item">
	    <p>Bicicleta -> Número de serie: ${item.numSerie}   |	Color: ${item.color}	|	 Estado reparación: ${item.estadoReparacionAsString}<br></p>
	</c:forEach>
	
	<br>
	<br>
	<a href="${context}">Volver a menú</a>
</body>
</html>