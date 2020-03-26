<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin ended games</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
  <div id="container_player">
	<table>
  <tr>
    <td width=22%><font size="+1">Nom du jeu</font></td>
    <td width=22%><font size="+1">Pseudo du joueur</font></td>
    <td width=22%><font size="+1">Date/heure de début</font></td>
    <td width=22%><font size="+1">Date/heure de fin</button></td>
    <td width=22%><font size="+1">Temps de jeu</button></td>
  </tr>
  <% 
	ArrayList<Play> plays = (ArrayList<Play>) request.getAttribute("plays");
	for(int i=0;i<plays.size();i++){
		if(end!=null){
		date tempsjeu = //parties.get(i).getEnd() - parties.get(i).getStart();
		system.out.println(
		<tr>
			<td>parties.get(i).getIdgame()//.getName()</td>
   			<td>parties.get(i).getIdplayer//.getName()</td>
    			<td>parties.get(i).getStart()</td>
			<td>parties.get(i).getEnd()</td>
			<td>tempsjeu</td>
		</tr>)
	}
	}
%>


	</table>
  </div>
</body>
</html>
