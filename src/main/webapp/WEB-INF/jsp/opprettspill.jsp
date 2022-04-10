<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- <script src="js/OpprettSpill.js" type="module"></script> -->
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title>Logg inn</title>
</head>
<body>
<!--     <div id="root"> -->
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
                    <%-- <tr>
                        <td>${spiller1}</td>
                    </tr>
                    <tr>
                        <td>${spiller2}</td>
                    </tr>
                    <tr>
                        <td>${spiller3}</td>
                    </tr>
                    <tr>
                        <td>${spiller4}</td>
                    </tr>
                    <tr>
                        <td>${spiller5}</td>
                    </tr> --%>
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
    
        <%-- <table>
            <tbody id="tabell">
                <tr>
                    <td><strong>Spillere</strong></td>
                </tr>
                <tr>
                    <td>${admin}</td>
                </tr>
            </tbody>
        </table>
    
        <span>
            <input type="text" id="inputId"></input>
            <button>Legg til spiller</button>
        </span>
   
    
        <form method="post">
            <fieldset>
                <button type="submit">Start spill</button>
            </fieldset>
    
        </form> --%>
<!--     </div> -->
</body>
</html>