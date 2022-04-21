package presentation.spillside;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.RundeoversiktDAO;
import model.Rundeoversikt;
import model.Yatzyspill;

/**
 * Servlet implementation class SpillYatzyServlet
 */
@WebServlet(name = "SpillYatzyController", urlPatterns = "/spillyatzy")
public class SpillYatzyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private RundeoversiktDAO rundeDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Yatzyspill yatzyspill = (Yatzyspill) request.getSession().getAttribute("yatzyspill");

		int[] terninger = yatzyspill.getTerningVerdier();
		request.setAttribute("dice1", terninger[0]);
		request.setAttribute("dice2", terninger[1]);
		request.setAttribute("dice3", terninger[2]);
		request.setAttribute("dice4", terninger[3]);
		request.setAttribute("dice5", terninger[4]);

		request.setAttribute("antallkast", yatzyspill.getAntallKast());
		request.setAttribute("spillerListe", yatzyspill.hentSpillereString());
		request.setAttribute("spillerSinTur", yatzyspill.getSpillerSinTur());

		for (int i = 0; i < yatzyspill.getSpillere().length; i++) {
			request.setAttribute(("spiller" + (i + 1) + "liste"), yatzyspill.hentSpillerPoeng(i));
		}

		request.setAttribute("terningStatus", yatzyspill.terningStatus());

		request.getRequestDispatcher("WEB-INF/jsp/spillyatzy.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Yatzyspill yatzyspill = (Yatzyspill) request.getSession().getAttribute("yatzyspill");

		// if(LoggInnUtil.erSpillerSinTur(yatzyspill.hentSpillerSinTur(), request)) {
		boolean terning1 = request.getParameter("terning1") != null;
		boolean terning2 = request.getParameter("terning2") != null;
		boolean terning3 = request.getParameter("terning3") != null;
		boolean terning4 = request.getParameter("terning4") != null;
		boolean terning5 = request.getParameter("terning5") != null;

		boolean[] terningTilstander = { terning1, terning2, terning3, terning4, terning5 };
		yatzyspill.spillTur(request.getParameter("command"), terningTilstander);
		if (yatzyspill.isOppdater()) {

			Rundeoversikt ro1 = new Rundeoversikt(yatzyspill.getRundeNr(), yatzyspill.getSpillid(),
					yatzyspill.getPoengtabell().hentRad(yatzyspill.getRundeNr()));
			Rundeoversikt ro2 = new Rundeoversikt(yatzyspill.getRundeNr(), yatzyspill.getSpillid(),
					yatzyspill.getPoengtabell().hentRad(yatzyspill.getForrigeRunde()));

			rundeDAO.nyRundeOversikt(ro1);
			rundeDAO.nyRundeOversikt(ro2);
			yatzyspill.setOppdater(false);
		}

		doGet(request, response);
	}

}