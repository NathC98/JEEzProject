<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz games</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
Jeux en cours

<%
    int idjoueur = Integer.parseInt((String)request.getAttribute("Identifiant"));
    int idjeu = Integer.parseInt((String)request.getAttribute("Idjeu"));
    out.println("<button id=\"end\" onclick=\"window.location.href = './JEEprojetended?id=" + idjoueur +"&idjeu="+ idjeu +"';" type="cancelbtn\">Terminer le jeu</button>");
%>

</body>
</html>
