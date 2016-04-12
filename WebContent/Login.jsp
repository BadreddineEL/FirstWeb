<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<a href="ClimatisationController">saisie d'une climatisation</a>

	<form action="LoginController " method="Post">


		<Label> Nom : </Label> <input type="text" value="${nom}" name="nom" />
		<span>${nomInvalide}</span><br /> <input type="submit" value="OK"
			name="action" />

	</form>

</body>
</html>