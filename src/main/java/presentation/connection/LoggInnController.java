package presentation.connection;
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
import businessLogic.utils.LoggInnUtil;
import businessLogic.utils.PassordUtil;
import model.Bruker;

@WebServlet(name = "LoggInnServlet", urlPatterns ="/logginn")
public class LoggInnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BrukerDAO brukerDAO;
	String loginMessage = "";
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO check if already logged inn
		if (LoggInnUtil.erInnlogget(request)) {
			
		}
		request.setAttribute("loginMessage", loginMessage);
		loginMessage = "";
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("passord");
		String brukernavn = request.getParameter("brukernavn");
		Bruker bruker = brukerDAO.getBruker(brukernavn);

		// TODO sanitize input

		if (hasUser(bruker)) {
			String hash = bruker.getPassord();

			if(correctPass(password, hash)) {
				
				// request.getSession(true);
				// request.getSession(false).setAttribute("bruker", bruker);
				
				LoggInnUtil.loggInn(request, bruker);
				//placeholder, burde sette opp en main/index jsp om vi skal f�lge wireframes
				response.sendRedirect("opprettspill");
			} else {
				this.loginMessage = "Passord Stemmer ikke";
				doGet(request, response);
			}	
		} else {
			this.loginMessage = "Bruker eksisterer ikke";
			doGet(request, response);
		}
	} 

	public boolean correctPass(String password, String hash) {
		try {
			return PassordUtil.validatePassword(password, hash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ignored) { return false;
		}

	}

	public boolean hasUser(Bruker user) {
		return user != null;
	}
}
