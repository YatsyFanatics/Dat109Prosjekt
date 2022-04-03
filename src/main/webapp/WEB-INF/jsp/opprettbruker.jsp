<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="js/FORMController.js" type="module"></script>
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
                     <label for="Brukernavn">Brukernavn:</label> <input type="text"
                        name="Brukernavn" id="Brukernavn" value="${Brukernavn}"
                        placeholder="Fyll inn Brukernavn"
                        title="Brukernavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
                        required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*" /> <span
                        class="melding"> 
                        
                     </span> <label for="Fornavn">Fornavn:</label> <input type="text"
                        name="Fornavn" id="Fornavn" value="${Fornavn}"
                        placeholder="Fyll inn fornavn"
                        title="Fornavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
                        required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*" /> <span
                        class="melding"> 
                        
                    </span> <label for="Etternavn">Etternavn:</label> <input type="text"
                        name="Etternavn" id="Etternavn" value="${Etternavn}"
                        placeholder="Fyll inn etternavn"
                        title="Etternavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
                        required pattern="\s*\p{Lu}\p{Ll}+\s*" /> <span class="melding">
                        
                       
                    </span> <label for="epost">Epost:</label> <input type="text"
                        name="epost" id="epost" value="${epost}"
                        placeholder="Fyll inn din epost"
                        title="epost må være gyldig" 
                        required pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$" /> <span class="melding">
                       
    
                    </span> <label for="passord">Passord:</label> <input type="password"
                        name="passord" id="passord" value="" placeholder="Velg et passord"
                        title="Passordet må bestå av minst 8 tegn, men bør ha minst 14 tegn."
                        required pattern=".{8,}" /> <span class="melding"> 
                        
                    </span> <label for="passordRepetert">Passord repetert:</label> <input
                        type="password" name="passordRepetert" id="passordRepetert"
                        value="" placeholder="Gjenta passord" required /> <span
                        class="melding"> 
                       
                    </span>
                    <button type="submit">Opprett ny bruker</button>
                </fieldset>
            </form>
            
            <form method="post">
        <fieldset>
                <button type="submit">placeholder, skulle sende deg ein anna plass</button>
        </fieldset>
    </form>


</body>
</html>