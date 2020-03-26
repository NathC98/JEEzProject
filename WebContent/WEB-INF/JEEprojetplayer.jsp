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
    <td width=21%><font size="+1">Pseudo</font></td>
    <td width=21%><font size="+1">Date d'inscription</font></td>
    <td width=21%><font size="+1">Nombre de parties jouées</font></td>
    <td width=21%><font size="+1">interdire</button></td>
    <td width=21%><font size="+1">autorisation</font></td>
  </tr>
<% 
	ArrayList<Player> players = (ArrayList<Player>) request.getAttribute(".....");
	for(int i=0;i<players.size();i++){
		system.out.println(
		<tr>
			<td>players.get(i).getPseudo()</td>
   			<td>players.get(i).getInscriptiondate()</td>
    			<td>players.get(i).getNbpartiesjouees()</td>
    			
		);
		if(players.get(i).getBan()){
			system.out.println(<td><button type="button" class="cancelbtn">suspendre</button></td>
    			<td>oui</td>
			</tr>
		);
		}
		else{
			system.out.println(<td><button type="button" class="cancelbtn">autoriser</button></td>
    			<td>non</td>
			</tr>
		);
		}
	}
%>


	</table>
  </div>
</body>
</html>
