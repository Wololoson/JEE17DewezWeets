package be.gestionhopital.Controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.Factory.AbstractDAOFactory;
import be.gestionhopital.Models.Reservation;

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
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			DAOReservation reservationDAO = (DAOReservation) adf.getReservationDAO();
			
		    if(paramName.equals("chirRes")) {
		    	try {
					List<Reservation> lr = (List<Reservation>) reservationDAO.findAll();
					request.setAttribute("lr", lr);
		    	} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}
		    	
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    }
		    if(paramName.equals("chirNoti"))
		    	getServletContext().getRequestDispatcher(urlNotification).forward(request, response);
		    if(paramName.equals("chirInfo")) 
		    	getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
		    
		    if(paramName.equals("secrRes"))
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    if(paramName.equals("secrPati")) 
		    	getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
		    if(paramName.equals("secrInfo"))
		    	getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
		    
		    if(paramName.equals("direRes")) 
		    	getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
		    if(paramName.equals("direPati"))
		    	getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
		    if(paramName.equals("direPers")) 
		    	getServletContext().getRequestDispatcher(urlPersonnel).forward(request, response);
		    if(paramName.equals("direInfo"))
		    	getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
