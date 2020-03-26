<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz admin home</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
<div id="container_accueil_admin">
  <div class="imgcontainer">
    <img src="./logo.png" alt="Avatar" class="avatar">
  </div>
<div id="container_accueil_admin_player">
<img src="./playergestion.jpg" width=88%>
  <button type="player">Players gestion</button> 
</div>

<div id="container_accueil_admin_games">
<img src="./gamegestion.jpg" width=100%>
  <button type="player">Games gestion</button> 
</div>

<div id="container_accueil_admin_player">
<img src="./currentgames.png" width=90%>
  <button type="player">Current games</button> 
</div>
<div id="container_accueil_admin_games">
<img src="./endedgames.png" width=100%>
  <button type="player">Ended games</button> 
</div>

</div>      
</body>
</html>
