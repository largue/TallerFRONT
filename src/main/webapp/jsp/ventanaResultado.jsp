<%@page import="com.example.tallerrest.model.RespuestaServicio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />

<% RespuestaServicio rs = (RespuestaServicio) request.getSession().getAttribute("respuesta"); %>
<c:set var="codigo" value="<%=rs.getCodigo()%>" />
<c:set var="mensaje" value="<%=rs.getMensaje()%>" />

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
	<title>Resultado operación</title>
</head>
<body>
	<h1 align="center">Resultado operación</h1>
	
	<c:choose>
		<c:when test="${codigo == 'OK'}">
			<p class="ok">Código: ${codigo}</p>
		</c:when>
		<c:otherwise>
			<p class="ko">Código: ${codigo}</p>
		</c:otherwise>
	</c:choose>
	
	<p>Mensaje: ${mensaje}</p>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>