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
<div id=imgcontainer>
<img src="./logo.png" float=center>
</div>
<div id=login>
	<font size="+1">S'identifier pour jouer</font>
    <button type="submit">Login</button>
</div>
<div id=containergame><font size="+2">Nos jeux</font>
<li>
<%
	ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
	for(int i=0;i<games.size();i++) {
        out.println("<button id=\"gamebutton\" onclick=\"window.location.href = './JEEprojet.?id=<% out.println(\"id\") %>';\" type=\"submit\">jouer games.get(i).getName()</button>");
    }
%>
</li>
</div>  
</body>
</html>