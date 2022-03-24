package presentation.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.common.LoggInnUtil;

@WebServlet("/loggut")
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoggInnUtil.loggUt(request);
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);

	}

	}

