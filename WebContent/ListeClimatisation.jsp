<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.nom}">
			<div>${sessionScope.nom} est connecté</div>
			<a href="logoutController">se déconnecter</a>
			<br />
		</c:when>
		<c:otherwise>
			<a href="LoginController">se connecter</a>
			<br />
		</c:otherwise>
	</c:choose>
	<a href="ClimatisationController">saisie d'une climatisation</a>
	<br />
	<br />
	<br /> 
	
	<span style="color:red">${rechercheDataErreur}</span>
	
	${climatisations}
	
	<%-- <c:forEach var="clim" items="$(climatisations)">
			
			<h2> ${clim.nomAppareil} ----  ${clim.pression} </h2>
		
		</c:forEach> --%>
</body>
</html>