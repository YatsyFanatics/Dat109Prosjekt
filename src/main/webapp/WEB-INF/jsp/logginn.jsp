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
    <span class="melding"> ${loginMessage} </span>

    <form method="post">
        <fieldset>
            <label for="brukernavn">Brukernavn:</label> <input type="text"
                placeholder="brukernavn" name="brukernavn" /><br> <label
                for="passord">Passord:</label> <input type="password"
                placeholder="Passord" name="passord" /><br>
            <button type="submit">Logg inn</button>
        </fieldset>
    </form>
    <a href="opprettbruker"><button>Opprett bruker</button></a>
</body>
</html>