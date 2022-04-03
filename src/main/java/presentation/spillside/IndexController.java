package presentation.spillside;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import model.Bruker;
import businessLogic.utils.LoggInnUtil;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	private BrukerDAO brukerDAO;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/jsp/index_in.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bruker> DAOliste = brukerDAO.hentAlleBrukere();
		if (LoggInnUtil.erInnlogget(request)) {
			request.setAttribute("DAOliste", DAOliste);
			request.getRequestDispatcher("WEB-INF/jsp/index_in.jsp").forward(request, response);
		} else {
			response.sendRedirect("WEB-INF/jsp/index_ut.jsp");
		}
	}

}
