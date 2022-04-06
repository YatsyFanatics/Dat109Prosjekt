<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="js/OpprettSpill.js" type="module"></script>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title>Logg inn</title>
</head>
<body>
	<h2>Opprett Spill!</h2>
	<span class="melding">
		${loginMessage}
	</span>
	
    <table>
        <tbody>
            <tr>
                <td><strong>Spillere</strong></td>
            </tr>
            <tr>
                <td>${admin}</td>
            </tr>
        </tbody>
    </table>
    
    <span>
        <input type="text" id="inputId">
        <button onclick="leggTilSpiller();">Legg til spiller</button>
    </span>
   
    
	<form method="post">
		<fieldset>
				<button type="submit">Start spill</button>
		</fieldset>
	
    </form>
</body>
</html>