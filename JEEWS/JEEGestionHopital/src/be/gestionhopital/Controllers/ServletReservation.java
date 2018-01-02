package be.gestionhopital.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOChirurgien;
import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.Factory.AbstractDAOFactory;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.ListPatient;
import be.gestionhopital.Models.ListReservation;
import be.gestionhopital.Models.Patient;
import be.gestionhopital.Models.Reservation;
import be.gestionhopital.Models.Salle;

/**
 * Servlet implementation class ServletReservation
 */
public class ServletReservation extends HttpServlet {
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
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			
			if(paramName.equals("ajout")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = null;
				ListPatient lp = ListPatient.getInstance();
				ListReservation lr = ListReservation.getInstance();
				
				if(type.equals("chirurgien")) {
					c = (Chirurgien)sess.getAttribute(type);
				}
				else {
					String idChir = (String)request.getAttribute("listChir");
					DAOChirurgien chirurgienDAO = (DAOChirurgien)adf.getChirurgienDAO();
					
					try {
						c = (Chirurgien)chirurgienDAO.find(Integer.parseInt(idChir));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SAXException e) {
						e.printStackTrace();
					}
				}
				
				String numPati = (String)request.getAttribute("numPati");
				String nomPati = (String)request.getAttribute("nomPati");
				String prenomPati = (String)request.getAttribute("prenomPati");
				String dateNaissPatiJ = (String)request.getAttribute("dateNaissPatiJ");
				String dateNaissPatiM = (String)request.getAttribute("dateNaissPatiM");
				String dateNaissPatiA = (String)request.getAttribute("dateNaissPatiA");
				String numTelPati = (String)request.getAttribute("numTelPati");
				String numChPati = (String)request.getAttribute("numChPati");
				Patient pati = new Patient(numChPati, numPati, 0, nomPati, prenomPati, Date.valueOf(dateNaissPatiA+"-"+dateNaissPatiM+"-"+dateNaissPatiJ), numTelPati, "");
				lp.ajouterPatient(pati);
				
				String numSalle = (String)request.getAttribute("numSalle");
				String blocSalle = (String)request.getAttribute("blocSalle");
				Salle salle = new Salle(0, numSalle, blocSalle.charAt(0));
				salle.ajouterSalle();
				
				String heureResH = (String)request.getAttribute("heureResH");
				String heureResM = (String)request.getAttribute("heureResM");				
				String dateResJ = (String)request.getAttribute("dateResJ");
				String dateResM = (String)request.getAttribute("dateResM");
				String dateResA = (String)request.getAttribute("dateResA");
				Reservation res = new Reservation(c, salle, pati, Date.valueOf(dateResA+"-"+dateResM+"-"+dateResJ), heureResH+":"+heureResM);
				lr.ajouterReservation(res);
			}
			if(paramName.equals("modif")) {
				
			}
			if(paramName.equals("suppr")) {
				
			}
			if(paramName.equals("back")) {
				getServletContext().getRequestDispatcher(urlAccueil).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
