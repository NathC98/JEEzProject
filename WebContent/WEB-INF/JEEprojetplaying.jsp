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
<body>
<font size="+3">Jeux en cours</font>

<button id="end" onclick="window.location.href = './JEEprojetGAMECHOICE';" type="cancelbtn">Terminer le jeu</button>
<%
    Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
    ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
    int id = Integer.parseInt((String)request.getAttribute("Identifiant"));
    ArrayList<Player_has_Game> phg = null;
    for(int i=0;i<games.size();i++){
        phg = b.GameFromPlayerHasGame(games.get(i).getIdGame());
        for(int j=0;j<phg.size();j++) {
            if (phg.get(j).getIdPlayer() == id && phg.get(j).isFavorite()) {
                out.println("<button type=\"player\">Enlever des favoris</button>");
            }
            else{
                out.println("<button type=\"player\">Ajouter aux favoris</button>");
            }
        }
    }
%>


</body>
</html>