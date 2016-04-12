<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisation.js"></script>
</head>
<body>
	<c:if test="${not empty sessionScope.nom}">
		<div>${sessionScope.nom}estconnecté</div>
		<a href="logoutController"> se déconnecter</a>
		<br />
	</c:if>
	<c:if test="${empty sessionScope.nom}">
		<a href="LoginController"> se connecter</a>
		<br />
	</c:if>
	<a href="ListClimatisationController">liste des climatisations</a>
	<br />
	<br />
	<br />

	<form action="ClimatisationController " method="Post">

		<label> Nom de l'appareil : </label> <input id="sourceNbId"
			type="text" value="${NomAppareil}" name="nomAppareil" /><span
			style="color: red">${NomAppareilErreur}</span><br />
			 <span id="NbId" style="color:blue"></span><br /> 
			<label> Température : </label> <input type="text" value="${temperature}" name="temperature" />
			<span style="color: red">${temperatureErreur}</span><br />
		    <label> Pression : </label><input type="text" value="${pression}" name="pression" />
		    <span style="color: red"> ${Pression}</span><br/> 
		    <label> TauxHumidité : </label><input type="text" value="${tauxHumidite}"
			name="tauxHumidite" /><span style="color: red">${tauxHumidite}</span><br/>
		
		<input type="submit" value="Enregistrer" name="action" />
		<span style="color: red">${sauvegardeErreur}</span>
	</form>


</body>
</html>