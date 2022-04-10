package presentation.spillside;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Yatzyspill;

/**
 * Servlet implementation class SpillYatzyServlet
 */
@WebServlet(name = "SpillYatzyController", urlPatterns = "/spillyatzy")
public class SpillYatzyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		for(int i = 0; i < yatzyspill.getSpillere().length; i++) {
			request.setAttribute(("spiller" + (i+1) + "liste"), yatzyspill.hentSpillerPoeng(i));
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