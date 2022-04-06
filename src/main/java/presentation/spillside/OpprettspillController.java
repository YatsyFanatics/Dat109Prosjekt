package presentation.spillside;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.utils.LoggInnUtil;
import model.Bruker;
import model.Yatzyspill;

@WebServlet(name = "OpprettspillServlet", urlPatterns = "/opprettspill")
public class OpprettspillController extends HttpServlet {
	private static final long serialVersionUID = 1L;    

//	@EJB
//	private BrukerDAO bdao;

	private final int MAXSPILLERE = 6;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(LoggInnUtil.erInnlogget(request)) {
			Bruker admin = LoggInnUtil.innloggetBruker(request);
			request.setAttribute("admin", admin.getBrukernavn());
			request.getRequestDispatcher("WEB-INF/jsp/opprettspill.jsp").forward(request, response);
		}
		
		response.sendRedirect("index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int antallSpillere = MAXSPILLERE;
		for(int i = 1; i < MAXSPILLERE; i++) {
			if(request.getParameter("spiller" + i) == null) {
				antallSpillere = i;
				break;
			}
		}
		Bruker[] spillere = new Bruker[antallSpillere];
		spillere[0] = (Bruker) request.getAttribute("admin");
		for(int i = 1; i < antallSpillere; i++) {
			spillere[i] = new Bruker();
			spillere[i].setBrukernavn(request.getParameter("spiller" + i));
		}
		Yatzyspill yatzyspill = new Yatzyspill(spillere);
		request.setAttribute("yatzyspill", yatzyspill);
		response.sendRedirect("spillyatzy");
	}

}
