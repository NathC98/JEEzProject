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
<div id="back">
    <button onclick="window.location.href = './JEEprojetplayerhome';" type="button" class="cancelbtn">Déconnexion</button>
</div>
<body>
<div id=containergamefav><font size="+2">Choisissez un jeu parmis vos favoris</font>
    <li>
        <%
            Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
            ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
            int id = Integer.parseInt((String)request.getAttribute("Identifiant"));
            ArrayList<Player_has_Game> phg = null;
            String gamename = null ;
            for(int i=0;i<games.size();i++){
                phg = b.GameFromPlayerHasGame(games.get(i).getIdGame());
                for(int j=0;j<phg.size();j++) {
                    if (phg.get(j).getIdPlayer() == id && phg.get(j).isFavorite()) {
                        gamename = games.get(i).getName();
                        out.println("<button id=\"gamebutton\" onclick=\"window.location.href = './JEEprojetplaying?id="+ id +"&idgame=" + games.get(i).getIdGame() + "';\" type=\"submit\">jouer à " + gamename + "</button>");
                    }
                }
            }
        %>
    </li>
</div>
<div id=containergame><font size="+2">Choisissez un jeu parmis tous les jeux</font>
    <li>
        <%
            games = (ArrayList<Game>) request.getAttribute("games");
            for(int i=0;i<games.size();i++) {
                gamename = games.get(i).getName();
                out.println("<button id=\"gamebutton\" onclick=\"window.location.href = './JEEprojetplaying?id="+ id +"&idgame=" + games.get(i).getIdGame() + "';\" type=\"submit\">jouer à " + gamename + "</button>");
            }
        %>
    </li>
</div>
</body>
</html>