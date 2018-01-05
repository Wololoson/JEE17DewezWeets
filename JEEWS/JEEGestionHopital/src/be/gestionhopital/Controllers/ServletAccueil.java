package be.gestionhopital.Controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.gestionhopital.Models.ListNotification;
import be.gestionhopital.Models.ListPatient;
import be.gestionhopital.Models.ListPersonnel;
import be.gestionhopital.Models.ListReservation;

/**
 * Servlet implementation class ServletAccueil
 */
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlReservation = null;
	private String urlNotification = null;
	private String urlPatient = null;
	private String urlPersonnel = null;
	private String urlInformation = null;
       
	public void init() {
		ServletConfig config = getServletConfig();
		urlReservation = (String)config.getInitParameter("urlReservation");
		urlNotification = (String)config.getInitParameter("urlNotification");
		urlPatient = (String)config.getInitParameter("urlPatient");
		urlPersonnel = (String)config.getInitParameter("urlPersonnel");
		urlInformation = (String)config.getInitParameter("urlInformation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Enumeration<String> paramNames = request.getParameterNames();

		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			
		    if(paramName.equals("chirRes")) {
		    	ListReservation lr = ListReservation.getInstance();
				request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    }
		    
		    if(paramName.equals("chirNoti")) {
				ListNotification ln = ListNotification.getInstance();
				request.setAttribute("ln", ln);
		    	getServletContext().getRequestDispatcher(urlNotification).forward(request, response);
		    }
		    
		    if(paramName.equals("chirInfo")) {
		    	getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
		    }
		    
		    if(paramName.equals("secrRes")) {
		    	ListReservation lr = ListReservation.getInstance();
				request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    }
		    
		    if(paramName.equals("secrPati")) {
		    	ListPatient lp = ListPatient.getInstance();
		    	request.setAttribute("lp", lp);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
		    	getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
		    }
		    
		    if(paramName.equals("secrInfo")) {
		    	getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
		    }
		    
		    if(paramName.equals("direRes")) {
		    	ListReservation lr = ListReservation.getInstance();
		    	request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    }
		    
		    if(paramName.equals("direPati")) {
		    	ListPatient lp = ListPatient.getInstance();
		    	request.setAttribute("lp", lp);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
		    	getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
		    }
		    
		    if(paramName.equals("direPers")) {
		    	ListPersonnel lp = ListPersonnel.getInstance();
		    	request.setAttribute("lp", lp);
		    	getServletContext().getRequestDispatcher(urlPersonnel).forward(request, response);
		    }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
