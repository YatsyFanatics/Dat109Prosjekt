package presentation.spillside;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.dao.BrukerDAO;
import model.Bruker;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO if innlogget -> index_in else index_ut
		request.getRequestDispatcher("WEB-INF/jsp/index_ut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (session.getAttribute("user") == null) {
		    response.sendRedirect(request.getContectPath() + "/index_ut"); // Not logged in, redirect to index ut page.
		} else {
		    chain.doFilter(request, response); // Logged in, just continue chain.
		}
		
	}

}
