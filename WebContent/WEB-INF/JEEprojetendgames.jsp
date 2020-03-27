<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin ended games</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<div id="back">
	<button onclick="window.location.href = './JEEprojetplayeraccueiladmin';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
  <div id="container_player">
	<table>
  <tr>
    <td width=22%><font size="+1">Nom du jeu</font></td>
    <td width=22%><font size="+1">Pseudo du joueur</font></td>
    <td width=22%><font size="+1">Date/heure de début</font></td>
    <td width=22%><font size="+1"><button>Date/heure de fin</button></font></td>
    <td width=22%><font size="+1"><button>Temps de jeu</button></font></td>
  </tr>
  <% 
	ArrayList<Play> plays = (ArrayList<Play>) request.getAttribute("plays");
	Gestion_JEEz_JDBC a = new Gestion_JEEz_JDBC();
	for(int i=0;i<plays.size();i++){
		if(plays.get(i).getEnd()!=null){
		String playtime = a.PlayTime(plays.get(i).getIdPlay);
		out.println(
				"<tr>"                                                +
						"<td>plays.get(i).getIdgame()//.getName()</td>" +
			   			"<td>plays.get(i).getIdplayer//.getName()</td>" +
			    			"<td>plays.get(i).getStart()</td>"          +
						"<td>plays.get(i).getEnd()</td>"                +
						"<td>playtime</td>"                               +
					"</tr>");
	}
	}
%>


	</table>
  </div>
</body>
</html>
