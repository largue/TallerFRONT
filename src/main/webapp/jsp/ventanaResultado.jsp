<%@page import="com.example.taller.model.RespuestaServicio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="../estilos.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado operación</title>
</head>
<body>
	<h1 align="center">Resultado operación</h1>
	
	<% RespuestaServicio rs = (RespuestaServicio) request.getSession().getAttribute("respuesta"); %>
	
	<p >Código: <%=rs.getCodigo()%></p>
	<p>Mensaje: <%=rs.getMensaje()%></p>
	
	<br>
	<br>
	<a href="<%=request.getContextPath()%>">Volver a menú</a>
</body>
</html>