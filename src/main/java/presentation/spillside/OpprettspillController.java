package presentation.spillside;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bruker;
import model.Yatzyspill;
import model.Spilldeltakelse;

import businessLogic.dao.SpilldeltakelseDAO;
import businessLogic.dao.YatzyspillDAO;
import businessLogic.dao.BrukerDAO;
import businessLogic.utils.LoggInnUtil;

/**
 * Servlet implementation class Opprettspill
 */
@WebServlet(name = "OpprettspillController", urlPatterns = "/opprettspill")
public class OpprettspillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO bdao;
	@EJB
	private YatzyspillDAO spillDAO;
	@EJB
	private SpilldeltakelseDAO spillDeltakerDAO;

	private ArrayList<Bruker> spillere;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (LoggInnUtil.erInnlogget(request)) {
			if (request.getSession().getAttribute("oppdatertListe") == null) {
				spillere = new ArrayList<Bruker>();
				request.getSession().setAttribute("spillerListe", spillere);
			}
			Bruker admin = LoggInnUtil.innloggetBruker(request);
			request.setAttribute("admin", admin.getBrukernavn());
			request.getRequestDispatcher("WEB-INF/jsp/opprettspill.jsp").forward(request, response);
		}

		response.sendRedirect("index");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		if (request.getParameter("command").equals("spiller")) {
			if (!bdao.erLedig(request.getParameter("nySpiller"))) {
				Bruker nySpiller = bdao.getBruker(request.getParameter("nySpiller"));
				spillere = (ArrayList<Bruker>) request.getSession().getAttribute("spillerListe");
				if (spillere == null) {
					spillere = new ArrayList<>();
				}
				spillere.add(nySpiller);
				request.getSession().setAttribute("spillerListe", spillere);
				request.getSession().setAttribute("oppdatertListe", true);
			} // else bruker finnes ikke???

			doGet(request, response);
		}

		if (request.getParameter("command").equals("start")) {
			spillere = (ArrayList<Bruker>) request.getSession().getAttribute("spillerListe");
			spillere.add(0, LoggInnUtil.innloggetBruker(request));
			Yatzyspill yatzyspill = new Yatzyspill(spillere.toArray(new Bruker[spillere.size()]));
			spillDAO.nyttSpill(yatzyspill);
			
			for(Bruker b: spillere) {
				Spilldeltakelse sd = new Spilldeltakelse(b, yatzyspill);
				spillDeltakerDAO.nySpilldeltakelse(sd);
			}
			
			request.getSession().setAttribute("yatzyspill", yatzyspill);
			response.sendRedirect("spillyatzy");
		}

	}
}
