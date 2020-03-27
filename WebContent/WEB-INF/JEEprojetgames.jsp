<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin games gestion</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<div id="back">
	<button onclick="window.location.href = './JEEprojetplayeracceuiladmin';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
  <div id="container_player">
	<table>
  <tr>
    <td width=70%><font size="+1">Nom du jeu</font></td>
    <td width=24%><font size="+1">Supprimer</font></td>
    <td width=24%><font size="+1">Jouable</font></td>
  </tr>
<% 
	ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
	for(int i=0;i<games.size();i++){
		out.println(
		"<tr>"                                                                    +
			"<td>games.get(i).getName()</td>"                                     +
   			"<td><button type=\"button\" class=\"cancelbtn\">Supprimer</button></td>");
		if(games.get(i).getPlayable()){
			out.println(
				"<td>oui</td>" +
		"</tr>");
		}
		else{
			out.println(
				"<td>non</td>" +
		"</tr>");
		}
	}
%>


	</table>
  <div id="add_games">
<font size="+2">Ajouter un jeu</font>
<br>
<br>
<label for="gname"><b>Nom du jeu</b></label>
<br>
    <input type="text" placeholder="Enter game name" name="gname" id="gname" required>
<br>
    <label for="playable"><b>Jouablilité</b></label>
<br>
    <input type="text" placeholder="Enter Yes or No" name="playable" id="playable" required>

    <button type="submit"><font size="+1">Ajouter</font></button>
  </div>
  </div>
</body>
</html>