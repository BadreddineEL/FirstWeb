<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage de la date du jour</title>

</head>
<body>
<h1>
   ${dateDuJour}
 </h1>
 <br/><Strong> il est : ${Heure}  heures et ${Minutes} minutes</Strong>
 
 <h2>les données mesurées sont: </h2>
 <u> <li>${clim1.getTemp()}</li><li> ${clim1.getPression()}</li><li> ${clim1.getTemperatureFarenheit()}</li></u>
 
 <h3> le prix de la voiture est : ${v.calculPrix()}</h3>
 <h3> le prix de la voitureSport est : ${voiture.calculPrix()}</h3>
 
 
</body>
</html>