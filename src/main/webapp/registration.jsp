<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>


<h2>Registrati</h2>


<form action="RegistrationServlet" method="post">

	<label class="mb-2" for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>
    <br>
    <label class="mb-2" for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome" required>
	<br>
	<label class="mb-2" for="data">Data di Nascita:</label>
	<br>
    <input type="date" id="data" name="data" required>
    <br>
    <label class="mb-2 mt-2" for="tel">Cellulare:</label>
    <br>
    <input type="tel" id="tel" name="tel" required>
    <br>
    <label class="mb-2 mt-2" for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="password">Password:</label>
    <br>
    <input type="password" id="password" name="password" required>
<br><br>
    <input type="submit" value="Invia">

</form>
</body>
</html>