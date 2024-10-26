<%@page import="com.example.tallerrest.model.RespuestaServicio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="context" value="<%=request.getContextPath()%>" />

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
	<title>Error desconocido</title>
</head>
<body>
	<h1 align="center">Error desconocido</h1>
	
	<table>
		<tr>
			<td><img src="${context}/images/error.png" width="50px"></td>
			<td><p class="ko">Se ha producido un error desconocido en el sistema</p></td>
		</tr>
	</table>
	
	<br>
	<br>
	<a href="${context}">Volver a menú</a>
</body>
</html>