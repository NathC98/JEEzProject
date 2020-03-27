<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin player gestion</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<div id="back">
	<button onclick="window.location.href = './JEEprojetplayeraccueiladmin';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
  <div id="container_player">
	<table>
  <tr>
    <td width=30%><font size="+1">Nom du jeu</font></td>
    <td width=30%><font size="+1">Pseudo du joueur</font></td>
    <td width=30%><font size="+1">Date/heure de début</font></td>
    <td width=30%><font size="+1"><button>Mettre fin</button></font></td>
  </tr>
  <% 
	ArrayList<Play> plays = (ArrayList<Play>) request.getAttribute("plays");
	for(int i=0;i<plays.size();i++){
		if(end==null){
		out.println(
		"<tr>"                                                                        +
			"<td>plays.get(i).getIdgame()//.getName()</td>"                           +
   			"<td>plays.get(i).getIdplayer//.getName()</td>"                           +
    			"<td>plays.get(i).getStart()</td>"                                    +
			"<td><button type=\"button\" class=\"cancelbtn\">Mettre fin</button></td>"+
		"</tr>");
	}
	}
%>


	</table>
  </div>
</body>
</html>
