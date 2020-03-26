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
	ArrayList<Partie> parties = (ArrayList<Partie>) request.getAttribute(".....");
	for(int i=0;i<players.size();i++){
		if(end==null){
		system.out.println(
		<tr>
			<td>parties.get(i).getIdgame()//.getName()</td>
   			<td>parties.get(i).getIdplayer//.getName()</td>
    			<td>parties.get(i).getStart()</td>
			<td><button type="button" class="cancelbtn">Mettre fin</button></td>
		</tr>)
	}
	}
%>


	</table>
  </div>
</body>
</html>
