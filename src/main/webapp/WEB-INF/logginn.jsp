<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<span class="melding">
		${loginMessage}
	</span>
	
	<form method="post">
		<fieldset>
			 	<label for="mobil">e-post:</label> <input type="text" placeholder="e-post" name="e-post" /><br>
				<label for="passord">Passord:</label> <input type="password" placeholder="Passord"
					name="passord"  /><br>
				<button type="submit">Logg inn</button>
					</fieldset>
	</form>
	<form method="post">
		<fieldset>
				<button type="submit">Opprett ny bruker</button>
					</fieldset>
	</form>

</body>
</html>