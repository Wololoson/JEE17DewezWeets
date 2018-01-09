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
import be.gestionhopital.Models.Directeur;
import be.gestionhopital.Models.ListPersonnel;
import be.gestionhopital.Models.Secretaire;

/**
 * Servlet implementation class ServletPersonnel
 */
public class ServletPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Déclaration des variables qui contiennent les URL
	private String urlAccueil,urlPersonnel;
	ListPersonnel lp = ListPersonnel.getInstance();
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlPersonnel = (String)config.getInitParameter("urlPersonnel");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		ListPersonnel lp = ListPersonnel.getInstance();
		
		// Actions en fonction de du parametre reçu (submit)
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			
			// Si on ajoute du personnel
			if(paramName.equals("ajout")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Directeur d = (Directeur)sess.getAttribute(type);
				
				// Vérification des informations
				boolean persOK = true;
				
				String typeAdd = (String)request.getParameter("listPers");
				String nom = (String)request.getParameter("nom");
				String prenom = (String)request.getParameter("prenom");
				String dateNaissJ = (String)request.getParameter("dateNaissJ");
				String dateNaissM = (String)request.getParameter("dateNaissM");
				String dateNaissA = (String)request.getParameter("dateNaissA");
				String numTel = (String)request.getParameter("numTel");
				String spec = (String)request.getParameter("spec");
				String serv = (String)request.getParameter("serv");
				Chirurgien c = null;
				Secretaire s = null;
				
				if(!nom.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le nom doit faire maximum 50 caractères et ne contenir aucun chiffres.");
					persOK = false;
				}
				if(!prenom.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le prénom doit faire maximum 50 caractères et ne contenir aucun chiffres.");
					persOK = false;
				}
				if(!dateNaissJ.matches("^[0-9]{2}$")) {
					erreurs.add("Le jour de la date de naissance doit faire 2 caractères et ne contenir que des chiffres.");
					persOK = false;
				}
				if(!dateNaissM.matches("^[0-9]{2}$")) {
					erreurs.add("Le mois de la date de naissance doit faire 2 caractères et ne contenir que des chiffres.");
					persOK = false;
				}
				if(!dateNaissA.matches("^[0-9]{4}$")) {
					erreurs.add("L'année de la date de naissance doit faire 4 caractères et ne contenir que des chiffres.");
					persOK = false;
				}
				if(!numTel.matches("^(0)(\\d){3}(\\/)((\\d){2}(\\.)){2}(\\d){2}$")) {
					erreurs.add("Le numéro de téléphone doit faire au minimum 13 caractères, au maximum 20 caractères et respecter le canvas.");
					persOK = false;
				}
				
				if(typeAdd.equals("chirurgien")) {
					if(!spec.matches("^[a-zA-Z]{1,30}$")) {
						erreurs.add("La spécialisation doit faire maximum 30 caractères et ne contenir que des chiffres.");
						persOK = false;
					}
				}
				else {
					if(!serv.matches("^[a-zA-Z]{1,30}$")) {
						erreurs.add("Le service doit faire maximum 30 caractères et ne contenir que des chiffres.");
						persOK = false;
					}
				}
				
				// Si tout est OK
				if(persOK) {
					// On ajoute selon le type choisi
					if(typeAdd.equals("chirurgien")) {
						c = new Chirurgien(spec, 0, nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, prenom+nom.toLowerCase().charAt(0)+dateNaissA.substring(2, 4));
						d.ajouterPersonnel(c);
					}
					else {
						s = new Secretaire(serv, 0, nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, prenom+nom.toLowerCase().charAt(0)+dateNaissA.substring(2, 4));
						d.ajouterPersonnel(s);
					}
				}
				
				// Redirection vers la même page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lp", lp);
				getServletContext().getRequestDispatcher(urlPersonnel).forward(request, response);
			}
			
			// Si on supprime du personnel
			if(paramName.equals("suppr")) {
				String i = (String)request.getParameter("chir");
				String j = (String)request.getParameter("secr");
				
				// Vérification de la sélection
				if(i != null || j != null) {
					HttpSession sess = request.getSession();
					String type = (String) sess.getAttribute("type");
					Directeur d = (Directeur)sess.getAttribute(type);
					Chirurgien c = null;
					Secretaire s = null;
					String typeSuppr = null;
					
					// Vérification du type de la sélection
					if(i != null) {
						typeSuppr = "chirurgien";
						c = (Chirurgien) sess.getAttribute("chir"+i);
					}
					else {
						typeSuppr = "secretaire";
						s = (Secretaire) sess.getAttribute("secr"+j);
					}
					
					// Suppression en fonction du type
					if(typeSuppr.equals("chirurgien"))
						d.supprimerPersonnel(c);
					else {
						d.supprimerPersonnel(s);
					}
				}
				else {
					// Gestion d'erreurs
					erreurs.add("Veuillez sélectionner une réservation");
				}
				// Redirection vers la même page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lp", lp);
				getServletContext().getRequestDispatcher(urlPersonnel).forward(request, response);
			}
			if(paramName.equals("retour")) {
				// Redirection vers l'accueil
				getServletContext().getRequestDispatcher(urlAccueil).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
