<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin ended games</title>
    <link rel="stylesheet" type="text/css" href="./html/style.css">
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
  <c:forEach var="partie" items="${requestScope['test']}">
  ArrayList<Partie> parties = (ArrayList<Partie>) request.getAttribute(".....");
	<% for(int i=0;i<players.size();i++){%>
	<s:if test="end!=null">
			date tempsjeu = //parties.get(i).getEnd() - parties.get(i).getStart();
			system.out.println(
			<tr>
				<td>parties.get(i).getIdgame()//.getName()</td>
   				<td>parties.get(i).getIdplayer//.getName()</td>
    				<td>parties.get(i).getStart()</td>
				<td>parties.get(i).getEnd()</td>
				<td>tempsjeu</td>
			</tr>)
		</s:if>
	}
  </c:forEach>


	</table>
  </div>
</body>
</html>
