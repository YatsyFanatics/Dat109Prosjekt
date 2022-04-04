<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title>YYYYYYYatzy time!!!!</title>
</head>
<body>
	<h2>Yatzy time!</h2>
	<span class="melding"> ${loginMessage} </span>
	<table>
		<tbody>
			<tr>
				<td><strong>Spillere:</strong></td>
				<td><span <c:if test="${spillerSinTur == 0}"> class="tur"</c:if>>  ${spillerListe[0]}</span></td>
				<td><span <c:if test="${spillerSinTur == 1}"> class="tur"</c:if>>  ${spillerListe[1]}</span></td>
				<td><span <c:if test="${spillerSinTur == 2}"> class="tur"</c:if>>  ${spillerListe[2]}</span></td>
				<td><span <c:if test="${spillerSinTur == 3}"> class="tur"</c:if>>  ${spillerListe[3]}</span></td>
				<td><span <c:if test="${spillerSinTur == 4}"> class="tur"</c:if>>  ${spillerListe[4]}</span></td>
				<td><span <c:if test="${spillerSinTur == 5}"> class="tur"</c:if>>  ${spillerListe[5]}</span></td>
			</tr>
			<tr>
				<td>Enere</td>
				<td>${spiller1liste[0]}</td>
				<td>${spiller2liste[0]}</td>
				<td>${spiller3liste[0]}</td>
				<td>${spiller4liste[0]}</td>
				<td>${spiller5liste[0]}</td>
				<td>${spiller6liste[0]}</td>
			</tr>
			<tr>
				<td>Toere</td>
				<td>${spiller1liste[1]}</td>
				<td>${spiller2liste[1]}</td>
				<td>${spiller3liste[1]}</td>
				<td>${spiller4liste[1]}</td>
				<td>${spiller5liste[1]}</td>
				<td>${spiller6liste[1]}</td>
			</tr>
			<tr>
				<td>Treere</td>
				<td>${spiller1liste[2]}</td>
				<td>${spiller2liste[2]}</td>
				<td>${spiller3liste[2]}</td>
				<td>${spiller4liste[2]}</td>
				<td>${spiller5liste[2]}</td>
				<td>${spiller6liste[2]}</td>
			</tr>
			<tr>
				<td>Firere</td>
				<td>${spiller1liste[3]}</td>
				<td>${spiller2liste[3]}</td>
				<td>${spiller3liste[3]}</td>
				<td>${spiller4liste[3]}</td>
				<td>${spiller5liste[3]}</td>
				<td>${spiller6liste[3]}</td>
			</tr>
			<tr>
				<td>Femere</td>
				<td>${spiller1liste[4]}</td>
				<td>${spiller2liste[4]}</td>
				<td>${spiller3liste[4]}</td>
				<td>${spiller4liste[4]}</td>
				<td>${spiller5liste[4]}</td>
				<td>${spiller6liste[4]}</td>
			</tr>
			<tr>
				<td>Seksere</td>
				<td>${spiller1liste[5]}</td>
				<td>${spiller2liste[5]}</td>
				<td>${spiller3liste[5]}</td>
				<td>${spiller4liste[5]}</td>
				<td>${spiller5liste[5]}</td>
				<td>${spiller6liste[5]}</td>
			</tr>
			<tr>
				<td><strong>SUM</strong></td>
				<td>${spiller1liste[6]}</td>
				<td>${spiller2liste[6]}</td>
				<td>${spiller3liste[6]}</td>
				<td>${spiller4liste[6]}</td>
				<td>${spiller5liste[6]}</td>
				<td>${spiller6liste[6]}</td>
			</tr>
			<tr>
				<td><strong>BONUS</strong></td>
				<td>${spiller1liste[7]}</td>
				<td>${spiller2liste[7]}</td>
				<td>${spiller3liste[7]}</td>
				<td>${spiller4liste[7]}</td>
				<td>${spiller5liste[7]}</td>
				<td>${spiller6liste[7]}</td>
			</tr>
			<tr>
				<td>Ett par</td>
				<td>${spiller1liste[8]}</td>
				<td>${spiller2liste[8]}</td>
				<td>${spiller3liste[8]}</td>
				<td>${spiller4liste[8]}</td>
				<td>${spiller5liste[8]}</td>
				<td>${spiller6liste[8]}</td>
			</tr>
			<tr>
				<td>To par</td>
				<td>${spiller1liste[9]}</td>
				<td>${spiller2liste[9]}</td>
				<td>${spiller3liste[9]}</td>
				<td>${spiller4liste[9]}</td>
				<td>${spiller5liste[9]}</td>
				<td>${spiller6liste[9]}</td>
			</tr>
			<tr>
				<td>3 like</td>
				<td>${spiller1liste[10]}</td>
				<td>${spiller2liste[10]}</td>
				<td>${spiller3liste[10]}</td>
				<td>${spiller4liste[10]}</td>
				<td>${spiller5liste[10]}</td>
				<td>${spiller6liste[10]}</td>
			</tr>
			<tr>
				<td>4 like</td>
				<td>${spiller1liste[11]}</td>
				<td>${spiller2liste[11]}</td>
				<td>${spiller3liste[11]}</td>
				<td>${spiller4liste[11]}</td>
				<td>${spiller5liste[11]}</td>
				<td>${spiller6liste[11]}</td>
			</tr>
			<tr>
				<td>Liten straight</td>
				<td>${spiller1liste[12]}</td>
				<td>${spiller2liste[12]}</td>
				<td>${spiller3liste[12]}</td>
				<td>${spiller4liste[12]}</td>
				<td>${spiller5liste[12]}</td>
				<td>${spiller6liste[12]}</td>
			</tr>
			<tr>
				<td>Stor straight</td>
				<td>${spiller1liste[13]}</td>
				<td>${spiller2liste[13]}</td>
				<td>${spiller3liste[13]}</td>
				<td>${spiller4liste[13]}</td>
				<td>${spiller5liste[13]}</td>
				<td>${spiller6liste[13]}</td>
			</tr>
			<tr>
				<td>Hus</td>
				<td>${spiller1liste[14]}</td>
				<td>${spiller2liste[14]}</td>
				<td>${spiller3liste[14]}</td>
				<td>${spiller4liste[14]}</td>
				<td>${spiller5liste[14]}</td>
				<td>${spiller6liste[14]}</td>
			</tr>
			<tr>
				<td>Sjanse</td>
				<td>${spiller1liste[15]}</td>
				<td>${spiller2liste[15]}</td>
				<td>${spiller3liste[15]}</td>
				<td>${spiller4liste[15]}</td>
				<td>${spiller5liste[15]}</td>
				<td>${spiller6liste[15]}</td>
			</tr>
			<tr>
				<td>Yatzy</td>
				<td>${spiller1liste[16]}</td>
				<td>${spiller2liste[16]}</td>
				<td>${spiller3liste[16]}</td>
				<td>${spiller4liste[16]}</td>
				<td>${spiller5liste[16]}</td>
				<td>${spiller6liste[16]}</td>
			</tr>
			<tr>
				<td><strong>TOTAL</strong></td>
				<td>${spiller1liste[17]}</td>
				<td>${spiller2liste[17]}</td>
				<td>${spiller3liste[17]}</td>
				<td>${spiller4liste[17]}</td>
				<td>${spiller5liste[17]}</td>
				<td>${spiller6liste[17]}</td>
			</tr>
		</tbody>
	</table>



	<form method="post">
		<table>
			<tr>
				<td><img id='d0' src="images/dice${dice1}.gif" alt="${dice1}"
					onclick="holddice()"></td>
				<td><img id='d1' src="images/dice${dice2}.gif" alt="${dice2}"
					onclick="holddice()"></td>
				<td><img id='d2' src="images/dice${dice3}.gif" alt="${dice3}"
					onclick="holddice()"></td>
				<td><img id='d3' src="images/dice${dice4}.gif" alt="${dice4}"
					onclick="holddice()"></td>
				<td><img id='d4' src="images/dice${dice5}.gif" alt="${dice5}"
					onclick="holddice()"></td>
					<td>Kast ${antallkast} av 3 </td>
			</tr>
			<tr>
				<td><input type="checkbox" id="terning1" name="terning1" value="true"></td>
				<td><input type="checkbox" id="terning2" name="terning2" value="true"></td>
				<td><input type="checkbox" id="terning3" name="terning3" value="true"></td>
				<td><input type="checkbox" id="terning4" name="terning4" value="true"></td>
				<td><input type="checkbox" id="terning5" name="terning5" value="true"></td>
			</tr>
		</table>


		<fieldset>
			<button name="command" type="submit" value="trill">Trill</button>
			<button name="command" type="submit" value="ferdig">Ferdig</button>
			<button type="submit">logg ut</button>
		</fieldset>
	</form>

</body>
</html>