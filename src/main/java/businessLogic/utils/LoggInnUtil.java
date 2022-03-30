package businessLogic.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bruker;

public class LoggInnUtil {
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		return sesjon != null && sesjon.getAttribute("bruker") != null;
	}
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
	}

	public static void loggInn(HttpServletRequest request, Bruker bruker) {
		loggUt(request);

		HttpSession sesjon = request.getSession(true);
		sesjon.setAttribute("bruker", bruker);
	}
	
}
