package presentation.connection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.utils.LoggInnUtil;

@WebServlet(name = "LoggUtController", urlPatterns = "/loggut")
public class LoggUtController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoggInnUtil.loggUt(request);
		request.getRequestDispatcher("WEB-INF/jsp/index_ut.jsp").forward(request, response);

	}

}
