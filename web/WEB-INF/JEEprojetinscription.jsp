<%@ page import="AppClasses.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz inscription</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<div id="back">
    <button onclick="window.location.href = './JEEprojetplayerhome';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
 <form action="action_page.php" method="post">
  <div class="imgcontainer">
    <img src="./logo.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="pseudo"><b>Pseudo</b></label>
<br>
    <input type="text" placeholder="Enter Pseudo" name="pseudo" required>
<br>
    <label for="psw"><b>Password</b></label>
<br>
    <input type="password" placeholder="Enter Password" name="psw" required>
<br>
    <label for="favorite_games"><b>Favorite games (space with , )</b></label>
<br>
    <input type="text" placeholder="Enter favorite games" name="favorite_games" required>
<br>
    <label for="date"><b>Date of birth</b></label>
<br>
<br>
    <input type="date" name="date" required>
<br>
<br>
    <label for="email"><b>Email</b></label>
<br>
    <input type="text" placeholder="Enter email" name="email" required>


    <button type="submit">Sign in</button>
<br>
    
  </div>


</form> 
        
</body>
</html>
