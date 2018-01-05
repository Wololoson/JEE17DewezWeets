package be.gestionhopital.Controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPersonnel
 */
public class ServletPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlAccueil;
	
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			
			if(paramName.equals("ajout")) {
				
			}
			if(paramName.equals("modif")) {

			}
			if(paramName.equals("suppr")) {

			}
			if(paramName.equals("retour")) {
				getServletContext().getRequestDispatcher(urlAccueil).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
