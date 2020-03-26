<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz games</title>
    <link rel="stylesheet" type="text/css" href="./html/style.css">
</head>
<body>
<div id=containergamefav><font size="+2">Choisissez un jeu parmis vos favoris</font>
    <li>
        <%
            ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
            for(int i=0;i<games.size();i++){
                if(games.get(i).getFavorite()){
                    system.out.println(<button id="gamebutton" type="submit">jouer games.get(i).getName()</button>
                }
            }
        %>
    </li>
</div>
<div id=containergame><font size="+2">Choisissez un jeu parmis tous les jeux</font>
    <li>
        <%
            ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
            for(int i=0;i<games.size();i++){
                system.out.println(<button id="gamebutton" type="submit">jouer games.get(i).getName()</button>

        %>
    </li>
</div>
</body>
</html>
