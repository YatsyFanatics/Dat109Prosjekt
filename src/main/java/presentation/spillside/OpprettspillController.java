package presentation.spillside;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import businessLogic.dao.RundeoversiktDAO;
import businessLogic.dao.SpilldeltakelseDAO;
import businessLogic.dao.YatzyspillDAO;
import model.Bruker;
import model.Rundeoversikt;
import model.Spilldeltakelse;
import model.Yatzyspill;

/**
 * Servlet implementation class Opprettspill
 */
@WebServlet(name = "OpprettspillServlet", urlPatterns = "/opprettspill")
public class OpprettspillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO brukerDAO;

	@EJB
	private YatzyspillDAO spillDAO;
	
	@EJB
	private SpilldeltakelseDAO spillDeltakerDAO;
	
	@EJB
	private RundeoversiktDAO rundeDAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.getRequestDispatcher("WEB-INF/jsp/opprettspill.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Bruker admin = new Bruker("endre", "endre", "ros", "hei@hade.ru", "pass");

		Bruker tufs = new Bruker("eivind", "eivind", "myx", "deg@hade.ru", "pass");

		if (!brukerDAO.nyBruker(admin)) {
			admin = brukerDAO.getBruker("endre");
		}

		if (brukerDAO.nyBruker(tufs)) {
			tufs = brukerDAO.getBruker("eivind");
		}

		Bruker[] spillere = { admin, tufs };

		Yatzyspill nyttSpill = new Yatzyspill(admin, spillere);

		spillDAO.nyttSpill(nyttSpill);
		
		Spilldeltakelse sd1 = new Spilldeltakelse(admin,nyttSpill);
		Spilldeltakelse sd2 = new Spilldeltakelse(tufs,nyttSpill);
		
		spillDeltakerDAO.nySpilldeltakelse(sd1);
		spillDeltakerDAO.nySpilldeltakelse(sd2);
		
		
		Rundeoversikt rundeOS1 = new Rundeoversikt(0, nyttSpill, 3, 1, null, null, null,null);
		
		Rundeoversikt rundeOS2 = new Rundeoversikt(1, nyttSpill, 8, 6, null, null, null, null);
		
		Rundeoversikt rundeOS3 = new Rundeoversikt(0, nyttSpill, 3, 5, null, null, null,null);
		
		rundeDAO.nyRundeOversikt(rundeOS1);
		
		rundeDAO.nyRundeOversikt(rundeOS2);
		
		rundeDAO.oppdater(rundeOS3);

		response.sendRedirect("spillyatzy");


	}

}
