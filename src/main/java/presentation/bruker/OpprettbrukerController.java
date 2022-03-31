package presentation.bruker;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import businessLogic.utils.PassordUtil;
import model.Bruker;

/**
 * Servlet implementation class Opprettbruker
 */
@WebServlet(name = "Opprettbruker", urlPatterns= "/opprettbruker")
public class OpprettbrukerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BrukerDAO db;  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/opprettbruker.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Bruker bruker = new Bruker();
		String brukernavn = request.getParameter("Brukernavn");
		String epost = request.getParameter("epost");
		String passord = request.getParameter("passord");


		if (db.hasBruker(brukernavn)) {
			// TODO når brukernavn er tatt			
		} else if (db.hasEpost(epost)) {
				// TODO når epost er tatt			
			} else {
				bruker.setBrukernavn(brukernavn);
				bruker.setFornavn(request.getParameter("Fornavn"));
				bruker.setEtternavn(request.getParameter("Etternavn"));
				bruker.setEpost(epost);
				bruker.setPassord(hashAndSaltPassword(passord));
				db.nyBruker(bruker);
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
