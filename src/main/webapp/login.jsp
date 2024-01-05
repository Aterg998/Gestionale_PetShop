<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>

<h2>Effettua il Login</h2>

<form action="LoginServlet" method="post">

	<label class="mb-2" for="username">Username:</label>
	<br>
    <input type="text" id="username" name="username" required> 
    <label class="mt-2 mb-2" for="password">Password:</label>
    <br>
    <input type="password" id="password" name="password" required>
	<br><br>
    <input type="submit" value="login">
    
    <h3 class="mt-3">Non hai un account? <a href="registration.jsp"> Registrati qui </a></h3>

</form>
</body>
</html>