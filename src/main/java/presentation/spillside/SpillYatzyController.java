package presentation.spillside;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import businessLogic.utils.LoggInnUtil;
import model.Yatzyspill;

/**
 * Servlet implementation class SpillYatzyServlet
 */
@WebServlet(name = "SpillYatzyController", urlPatterns = "/spillyatzy")
public class SpillYatzyController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	@EJB
	private BrukerDAO brukerDAO;//Fjern etter testing
	Yatzyspill yatzyspill = new Yatzyspill(brukerDAO.getBruker("bruker")); //placeholder
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/spillyatzy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(LoggInnUtil.erSpillerSinTur(yatzyspill.hentSpillerSinTur(), request)) {
			//Kan gjøres om på med metodene som ligger i terning klassen
			boolean terning1 = Boolean.parseBoolean(request.getParameter("terning1"));
			boolean terning2 = Boolean.parseBoolean(request.getParameter("terning2"));
			boolean terning3 = Boolean.parseBoolean(request.getParameter("terning3"));
			boolean terning4 = Boolean.parseBoolean(request.getParameter("terning4"));
			boolean terning5 = Boolean.parseBoolean(request.getParameter("terning5"));

			boolean[] terningTilstander = {terning1, terning2, terning3, terning4, terning5};
			yatzyspill.spillTur(request.getParameter("command"), terningTilstander);
		}
		//fjern under etter testing
		boolean terning1 = Boolean.parseBoolean(request.getParameter("terning1"));
		boolean terning2 = Boolean.parseBoolean(request.getParameter("terning2"));
		boolean terning3 = Boolean.parseBoolean(request.getParameter("terning3"));
		boolean terning4 = Boolean.parseBoolean(request.getParameter("terning4"));
		boolean terning5 = Boolean.parseBoolean(request.getParameter("terning5"));

		boolean[] terningTilstander = {terning1, terning2, terning3, terning4, terning5};
		yatzyspill.spillTur(request.getParameter("command"), terningTilstander);
		
//		response.sendRedirect("loggut");
	}

}
