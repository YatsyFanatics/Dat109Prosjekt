package presentation.connection;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import businessLogic.utils.LoggInnUtil;
import businessLogic.utils.Validator;
import model.Bruker;

@WebServlet(name = "LoggInnServlet", urlPatterns ="/logginn")
public class LoggInnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BrukerDAO brukerDAO;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginMessage = "";
		
        if (request.getParameter("invalidinput") != null) {
        loginMessage = "Ugyldig brukernavn og/eller passord";
        
        }  else if (request.getParameter("invalidbruker") != null) {
        	loginMessage = "Bruker eksisterer ikke";
        } else if (request.getParameter("passwrong") != null) {
        	loginMessage = "Passord Stemmer ikke";
        }
		
        request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passord = request.getParameter("passord");
		String brukernavn = request.getParameter("brukernavn");
		
		if(!brukerDAO.erLedig(brukernavn)) {
			Bruker bruker = brukerDAO.getBruker(brukernavn);
			if(true) {
				//TODO passord validering ovenfor i if
				request.getSession(true);
				request.getSession(false).setAttribute("bruker", bruker);
				response.sendRedirect("opprettspill"); //placeholder, burde sette opp en main/index jsp om vi skal følge wireframes
			} else {
				response.sendRedirect("passwrong");
			}	
		} else {
			response.sendRedirect("invalidbruker");
		}
		
		//Dunno ka som skjer under her TBH
		
//		if (epost == null && passord == null || !Validator.isValidEpost(epost)) {
//			response.sendRedirect("opprettspill");
			//response.sendRedirect("logginn" + "?invalidinput");
		} /*else {
		//Bruker x = brukerDAO.hentBruker(epost);

		  if( x == null ) { 
			response.sendRedirect("logginn" + "?invaliddeltager");
		} else if (Validator.finnPassord(x, passord)) {
			LoggInnUtil.loggInn(request, x);
			response.sendRedirect("oprettspill");

		} else { 
			
			response.sendRedirect("logginn" + "?passwrong");
		}
	}*/
//	}
}
