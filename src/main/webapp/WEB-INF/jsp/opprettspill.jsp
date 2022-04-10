<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h2>Opprett Spill!</h2>
        <span class="melding">
            ${loginMessage}
        </span>
        
        <form method="post">
            <table>
                <tbody>
                    <tr>
                        <td><strong>Spillere:</strong></td>
                    </tr>
                    <tr>
                        <td>${admin}</td>
                    </tr>
                    <c:forEach items="${spillerListe}" var="s">
                        <tr>
                            <td>${s.brukernavn}</td>
                        </tr>    
                    </c:forEach>
                </tbody>               
            </table>
            <fieldset>
                <span>
                    <input type="text" id="nySpiller" name="nySpiller"></input>
                    <button name="command" type="submit" value="spiller">Legg til spiller</button>
                    <button name="command" type="submit" value="start">Start spill</button>
                </span>
            </fieldset>           
        </form>
</body>
</html>