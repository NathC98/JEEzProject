<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JEEz login</title>
    <link rel="stylesheet" type="text/css" href="./html/style.css">
</head>
<div id="back">
    <button onclick="window.location.href = './JEEprojetGAMECHOICE';" type="button" class="cancelbtn">Retour</button>
</div>
<body>
 <form action="action_page.php" method="post">
  <div class="imgcontainer">
    <img src="./logo.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>New email</b></label>
<br>
    <input type="text" placeholder="Enter new email" name="uname" required>
<br>
    <label for="psw"><b>New password</b></label>
<br>
    <input type="password" placeholder="Enter New password" name="psw" required>

    <button type="submit">Enregistrer</button>
<br>

</form> 
        
</body>
</html>
