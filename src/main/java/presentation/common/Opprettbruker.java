package presentation.common;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.common.BrukerDAO;
import model.common.Bruker;

/**
 * Servlet implementation class Opprettbruker
 */
@WebServlet(name = "Opprettbruker", urlPatterns= "/opprettbruker")
public class Opprettbruker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private BrukerDAO bDAO;  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/opprettbruker.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bruker b = new Bruker();
		b.setBrukernavn(request.getParameter("Brukernavn"));
		b.setFornavn(request.getParameter("Fornavn"));
		b.setEtternavn(request.getParameter("Etternavn"));
		b.setEmail(request.getParameter("epost"));
		b.setPassord(request.getParameter("passord"));
		bDAO.nyBruker(b);
	}

}
