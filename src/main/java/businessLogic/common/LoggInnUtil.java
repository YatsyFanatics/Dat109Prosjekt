package businessLogic.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import presentation.common.Deltager;

public class LoggInnUtil {
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		return sesjon != null && sesjon.getAttribute("deltager") != null;
	}
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
	}

	public static void loggInn(HttpServletRequest request, Deltager deltager) {
		loggUt(request);

		HttpSession sesjon = request.getSession(true);
		sesjon.setAttribute("deltager", deltager);
	}
	
}
