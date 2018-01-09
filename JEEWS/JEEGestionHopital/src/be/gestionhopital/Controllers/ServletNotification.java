package be.gestionhopital.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.ListNotification;
import be.gestionhopital.Models.Notification;

/**
 * Servlet implementation class ServletNotification
 */
public class ServletNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Déclaration des variables qui contiennent les URL
	private String urlAccueil, urlNotification;
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlNotification = (String)config.getInitParameter("urlNotification");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		
		// Actions en fonction de du parametre reçu (submit)
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			ListNotification ln = ListNotification.getInstance();
			
			// Si on supprime une notification
			if(paramName.equals("suppr")) {
				// Vérification de la sélection d'un notification
				if(request.getParameter("noti") != null) {
					HttpSession sess = request.getSession();
					String type = (String) sess.getAttribute("type");
					Chirurgien c = (Chirurgien)sess.getAttribute(type);;
					Notification delNoti = (Notification) sess.getAttribute("noti"+request.getParameter("noti"));
					
					// Suppression
					c.supprimerNotification(delNoti);
				}
				else {
					// Gestion d'erreur
					erreurs.add("Veuillez sélectionner une notification");
				}
				
				// Redirection vers la même page dans tous les cas
				request.setAttribute("ln", ln);
				request.setAttribute("erreurs", erreurs);
				getServletContext().getRequestDispatcher(urlNotification).forward(request, response);
			}
			
			// Si on supprime toutes les notifications
			if(paramName.equals("supprAll")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = (Chirurgien)sess.getAttribute(type);
				
				// Suppression
				c.supprimerToutesNotification();
				
				// Redirection vers la même page dans tous les cas
				request.setAttribute("ln", ln);
				request.setAttribute("erreurs", erreurs);
				getServletContext().getRequestDispatcher(urlNotification).forward(request, response);
			}
			if(paramName.equals("retour")) {
				// Redirection vers la page d'accueil
				getServletContext().getRequestDispatcher(urlAccueil).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
