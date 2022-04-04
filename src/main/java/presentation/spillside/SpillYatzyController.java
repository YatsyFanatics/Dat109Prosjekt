package presentation.spillside;

import java.io.IOException;
import java.util.Random;

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

	Yatzyspill yatzyspill = new Yatzyspill(); // placeholder

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		TODO hent terninger fra spillet som kj�rer
//		int[] terninger = yatzyspill.getTerningVerdier();
//		Ligger for test

		/*
		 * Random trrr = new Random(); int[] terninger = new int[5]; for (int i = 0; i <
		 * 5; i++) { terninger[i] = trrr.nextInt(6) + 1; }
		 */

		int[] terninger = yatzyspill.getTerningVerdier();
		request.setAttribute("dice1", terninger[0]);
		request.setAttribute("dice2", terninger[1]);
		request.setAttribute("dice3", terninger[2]);
		request.setAttribute("dice4", terninger[3]);
		request.setAttribute("dice5", terninger[4]);
		
		request.setAttribute("antallkast", yatzyspill.getAntallKast());
		
		request.setAttribute("spillerListe", yatzyspill.hentSpillereString());
		
		request.setAttribute("spillerSinTur", yatzyspill.getSpillerSinTur());
		
		request.setAttribute("spiller1liste", yatzyspill.hentSpillerPoeng(0));
		request.setAttribute("spiller2liste", yatzyspill.hentSpillerPoeng(1));
		request.setAttribute("spiller3liste", yatzyspill.hentSpillerPoeng(2));
		request.setAttribute("spiller4liste", yatzyspill.hentSpillerPoeng(3));
		request.setAttribute("spiller5liste", yatzyspill.hentSpillerPoeng(4));
		request.setAttribute("spiller6liste", yatzyspill.hentSpillerPoeng(5));

		request.getRequestDispatcher("WEB-INF/jsp/spillyatzy.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if(LoggInnUtil.erSpillerSinTur(yatzyspill.hentSpillerSinTur(), request)) {
		boolean terning1;
		if (request.getParameter("terning1") == null) {
			terning1 = false;
		} else {
			terning1 = true;
		}
		boolean terning2;
		if (request.getParameter("terning2") == null) {
			terning2 = false;
		} else {
			terning2 = true;
		}
		boolean terning3;
		if (request.getParameter("terning3") == null) {
			terning3 = false;
		} else {
			terning3 = true;
		}
		boolean terning4;
		if (request.getParameter("terning4") == null) {
			terning4 = false;
		} else {
			terning4 = true;
		}
		boolean terning5;
		if (request.getParameter("terning5") == null) {
			terning5 = false;
		} else {
			terning5 = true;
		}

		boolean[] terningTilstander = { terning1, terning2, terning3, terning4, terning5 };
		yatzyspill.spillTur(request.getParameter("command"), terningTilstander);
		// }

		doGet(request, response);
	}

}
