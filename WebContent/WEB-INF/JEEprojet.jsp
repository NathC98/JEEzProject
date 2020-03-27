<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz login</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<div id="back">
    <button onclick="window.location.href = './JEEprojethome';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
 <form action="JEEprojet" method="post">
  <div class="imgcontainer">
    <img src="./logo.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
<br>
    <input type="text" placeholder="Enter Username" name="uname" id="uname" required>
<br>
    <label for="psw"><b>Password</b></label>
<br>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <button type="submit">Login</button>
<br>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
        
</body>
</html>
