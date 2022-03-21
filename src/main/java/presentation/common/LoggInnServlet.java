package presentation.common;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import presentation.common.DeltagerDAO;

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//@EJB
	//private DeltagerDAO deltagerDAO;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String loginMessage = "";
		
        if (request.getParameter("invalidinput") != null) {
        loginMessage = "Ugyldig brukernavn og/eller passord";
        
        }  else if (request.getParameter("invaliddeltager") != null) {
        	loginMessage = "Deltager eksisterer ikke";
        } else if (request.getParameter("passwrong") != null) {
        	loginMessage = "Passord Stemmer ikke";
        }
		
        request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passord = request.getParameter("passord");
		String mobil = request.getParameter("mobil");
	/*	
		if (mobil == null && passord == null || !Validator.isValidMobil(mobil)) {
			response.sendRedirect("logginn" + "?invalidinput");
		} else {
		Integer mob = Integer.parseInt(mobil);
		Deltager x = deltagerDAO.hentDeltager(mob);

		  if( x == null ) { 
			response.sendRedirect("logginn" + "?invaliddeltager");
		} else if (Validator.finnPassord(x, passord)) {
			LoggInnUtil.loggInn(request, x);
			response.sendRedirect("deltagerListe");

		} else { 
			
			response.sendRedirect("logginn" + "?passwrong");
		}
	}*/
	}
}
