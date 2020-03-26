<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin player gestion</title>
    <link rel="stylesheet" type="text/css" href="./html/style.css">
</head>
<body>
  <div id="container_player">
	<table>
  <tr>
    <td width=30%><font size="+1">Nom du jeu</font></td>
    <td width=30%><font size="+1">Pseudo du joueur</font></td>
    <td width=30%><font size="+1">Date/heure de début</font></td>
    <td width=30%><font size="+1">Mettre fin</button></td>
  </tr>
  <% 
	ArrayList<Play> plays = (ArrayList<Play>) request.getAttribute(".....");
	for(int i=0;i<plays.size();i++){
		if(end==null){
		system.out.println(
		<tr>
			<td>plays.get(i).getIdgame()//.getName()</td>
   			<td>plays.get(i).getIdplayer//.getName()</td>
    			<td>plays.get(i).getStart()</td>
			<td><button type="button" class="cancelbtn">Mettre fin</button></td>
		</tr>)
	}
	}
%>


	</table>
  </div>
</body>
</html>
