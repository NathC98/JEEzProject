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
    <td width=21%><font size="+1">Pseudo</font></td>
    <td width=21%><font size="+1">Date d'inscription</font></td>
    <td width=21%><font size="+1">Nombre de parties jouées</font></td>
	  <td width=21%><font size="+1"><button>interdire</button></font></td>
    <td width=21%><font size="+1">autorisation</font></td>
  </tr>
<% 
	ArrayList<Player> players = (ArrayList<Player>) request.getAttribute("players");
	int nbplays;
	Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
	int pseudo = -1 ;
	String inscriptiondate = null ;
	for(int i=0;i<players.size();i++){
		nbplays = b.NumberPlay(players.get(i).getIdPlayer());
		inscriptiondate = players.get(i).getDateinscription();
		pseudo = players.get(i).getIdIdentifiant();
		out.println("<tr>" + pseudo + "</td>"+
		"<td>" + inscriptiondate +"</td>"+
		"<td>" + nbplays + "</td>");
		if(players.get(i).isBan()){
			out.println("<td>"+"<button type=\"button\" class=\"cancelbtn\">suspendre</button>"+
		"</td>"+"<td>oui</td>"+"</tr>");
		}
		else{
			out.println("<td><button type=\"button\" class=\"cancelbtn\">autoriser</button></td>"+
		"<td>non</td>"+"</tr>");
		}
	}
%>


	</table>
  </div>
</body>
</html>