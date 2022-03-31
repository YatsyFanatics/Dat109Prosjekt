package presentation.bruker;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.dao.BrukerDAO;
import model.Bruker;

import businessLogic.utils.LoggInnUtil;
import businessLogic.utils.PassordUtil;
import businessLogic.utils.Validator;
import businessLogic.utils.PassordUtil;
/**
 * Servlet implementation class Opprettbruker
 */
@WebServlet(name = "Opprettbruker", urlPatterns = "/opprettbruker")
public class OpprettbrukerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String brukernavn;
	String fornavn;
	String etternavn;
	String epost;
	String passordPlain;
	String passordRepetert;
	StringBuilder feilmelding;

	@EJB
	private BrukerDAO bDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String feilkode = (String) request.getAttribute("feilmelding");
		if (feilkode != "null") {
			request.getRequestDispatcher("WEB-INF/jsp/opprettbruker.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/opprettbruker.jsp" + feilkode).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession sesjon = request.getSession();

		feilmelding = new StringBuilder();

		if (!Validator.isValidEpost(request.getParameter("epost"))) {
			feilmelding.append("&epostIn=feil");
		} else {
			epost = request.getParameter("epost");
//TODO denne sjekken for epost må endrest, funker ikkje
			if (!bDAO.epostErLedig(epost)) {
				feilmelding.append("&epostFinnes=" + epost);
			} else {
				sesjon.setAttribute("epost", epost);
			}
		}

		if (!Validator.isValidBrukernavn(request.getParameter("Brukernavn"))) {
			feilmelding.append("&brukerIn=feil");
		} else {
			brukernavn = request.getParameter("Brukernavn");
			if (!bDAO.erLedig(brukernavn)) {
				feilmelding.append("&brukernavnFinnes=" + brukernavn);
			} else {
				sesjon.setAttribute("Brukernavn", brukernavn);
			}
		}

		fornavn = request.getParameter("Fornavn");
		if (!Validator.isValidFornavn(fornavn)) {
			feilmelding.append("&fornavnIn=feil");
		} else {
			sesjon.setAttribute("Fornavn", fornavn);
		}
		etternavn = request.getParameter("Etternavn");
		if (!Validator.isValidEtternavn(etternavn)) {
			feilmelding.append("&etternavnIn=feil");
		} else {
			sesjon.setAttribute("Etternavn", etternavn);
		}

		passordPlain = request.getParameter("passord");
		if (!Validator.isValidPassordForst(passordPlain)) {
			feilmelding.append("&passordForstIn=feil");
		}

		passordRepetert = request.getParameter("passordRepetert");
		if (!Validator.isValidPassordRepetert(passordRepetert, passordPlain)) {
			feilmelding.append("&passordRepetertIn=feil");
		}

// her kan man generere passord, og logge automatisk inn etter bruker er opprettet
// eg kommenterer sikker passord lagring ut for andre jobber med passord og slikt so koden her kan
//endrest etterpå av de om det forsatt trengst. 

		if (feilmelding.toString().isEmpty()) {
//			try {
//				passord = Passord.lagPassord(passordForst);
//			} catch (Exception e) {
//				feilmelding.append("&passord-generering=feilet-prov-paa-nytt");
//			}
			
			String passordSikkert = hashAndSaltPassword(passordPlain);
			
			Bruker nyBruker = new Bruker(brukernavn, fornavn, etternavn, epost, passordSikkert);

			synchronized (this) {
				bDAO.nyBruker(nyBruker);
			}
			
//			sesjon.invalidate();
//			LoggInnUtil.loggInn(request, nyBruker);
			response.sendRedirect("opprettspill");
		} else {
			feilmelding.replace(0, 1, "?");
			response.sendRedirect("opprettbruker" + feilmelding.toString());

		}

	}

	private String hashAndSaltPassword(String passord) {
		try {
			return PassordUtil.generateStrongPasswordHash(passord);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ignore) { 
			return null;
		}
	}
	
}
