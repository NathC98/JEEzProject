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
    <button onclick="window.location.href = './JEEprojethome';" type="submit">Login</button>
    <button onclick="window.location.href = './JEEprojet';" type="submit">Inscription</button>
</div>
<div id=containergame><font size="+2">Nos jeux</font>
<li>
<%
	ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
	String gamename = null ;
	for(int i=0;i<games.size();i++) {
	    gamename = games.get(i).getName();
        out.println("<button id=\"gamebutton\" onclick=\"window.location.href = './JEEprojet';\" type=\"submit\">\"jouer à \" + gamename + \"</button>\"");
    }
%>
</li>
</div>  
</body>
</html>