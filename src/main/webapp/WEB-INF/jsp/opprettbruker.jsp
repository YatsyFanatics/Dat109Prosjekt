<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title>Opprett bruker</title>
</head>
<body>
	<h2>Opprett bruker</h2>
	<span class="melding">
		${loginMessage}
	</span>
	
	<form method="post">
		<fieldset>
			 	<label for="Brukernavn">Brukernavn:</label> <input type="text" placeholder="Brukernavn" name="Brukernavn" /><br>
				<label for="Fornavn">Fornavn:</label> <input type="text" placeholder="Fornavn" name="Fornavn"  /><br>
				<label for="Etternavn">Etternavn:</label> <input type="text" placeholder="Etternavn" name="Etternavn" /><br>
				<label for="epost">e-post:</label> <input type="text" placeholder="e-post" name="epost" /><br>
				<label for="passord">Passord:</label> <input type="password" placeholder="Passord" name="passord"  /><br>
                <label for="passord">Passord:</label> <input type="password" placeholder="PassordRepetert" name="passordrepetert"  /><br>
				<button type="submit">Opprett ny bruker</button>
		</fieldset>
	</form>
	<form method="post">
		<fieldset>
				<button type="submit">Opprett ny bruker</button>
		</fieldset>
	</form>

</body>
</html>