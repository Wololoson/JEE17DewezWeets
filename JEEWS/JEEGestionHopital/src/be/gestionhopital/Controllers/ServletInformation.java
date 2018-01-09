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
import be.gestionhopital.Models.Secretaire;

/**
 * Servlet implementation class ServletInformation
 */
public class ServletInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Déclaration des variables qui contiennent les URL
	private String urlAccueil = null;
	private String urlInformation = null;
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlInformation = (String)config.getInitParameter("urlInformation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		
		// Actions en fonction de du parametre reçu (submit)
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			
			// Si on valide les informations
			if(paramName.equals("valider")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = null;
				Secretaire s = null;
				String oldMdp = null;
				
				// Test du type de la personne connectée
				if(type.equals("chirurgien")) {
					c = (Chirurgien)sess.getAttribute(type);
					oldMdp = c.getMotDePasse();
				}
				else {
					s = (Secretaire)sess.getAttribute(type);
					oldMdp = s.getMotDePasse();
				}
				
				String mdp = (String)request.getParameter("motDePasse");
				
				// Vérification des informations
				if(mdp != null && mdp != "") {
					if(mdp.equals(oldMdp)) {
						String nom = (String)request.getParameter("nom");
						String prenom = (String)request.getParameter("prenom");
						String dateNaissJ = (String)request.getParameter("dateNaissJ");
						String dateNaissM = (String)request.getParameter("dateNaissM");
						String dateNaissA = (String)request.getParameter("dateNaissA");
						String numTel = (String)request.getParameter("numTel");
						String suppl = null;
						
						boolean infoOK = true;
						
						if(!nom.matches("^[a-zA-Z]{1,50}$")) {
							erreurs.add("Le nom doit faire maximum 50 caractères et ne contenir aucun chiffres.");
							infoOK = false;
						}
						if(!prenom.matches("^[a-zA-Z]{1,50}$")) {
							erreurs.add("Le prénom doit faire maximum 50 caractères et ne contenir aucun chiffres.");
							infoOK = false;
						}
						if(!dateNaissJ.matches("^[0-9]{2}$")) {
							erreurs.add("Le jour de la date de naissance doit faire 2 caractères et ne contenir que des chiffres.");
							infoOK = false;
						}
						if(!dateNaissM.matches("^[0-9]{2}$")) {
							erreurs.add("Le mois de la date de naissance doit faire 2 caractères et ne contenir que des chiffres.");
							infoOK = false;
						}
						if(!dateNaissA.matches("^[0-9]{4}$")) {
							erreurs.add("L'année de la date de naissance doit faire 4 caractères et ne contenir que des chiffres.");
							infoOK = false;
						}
						if(!numTel.matches("^(0)(\\d){3}(\\/)((\\d){2}(\\.)){2}(\\d){2}$")) {
							erreurs.add("Le numéro de téléphone doit faire au minimum 13 caractères, au maximum 20 caractères et respecter le canvas.");
							infoOK = false;
						}
						if(type.equals("chirurgien")) {
							suppl = (String)request.getParameter("specialisation");
							if(!suppl.matches("^[a-zA-Z]{1,30}$")) {
								erreurs.add("La spécialisation doit faire maximum 50 caractères et ne contenir aucun chiffres.");
								infoOK = false;
							}
						}
						else {
							suppl = (String)request.getParameter("service");
							if(!suppl.matches("^[a-zA-Z]{1,30}$")) {
								erreurs.add("Le service doit faire maximum 50 caractères et ne contenir aucun chiffres.");
								infoOK = false;
							}
						}
						
						// On modifie si tout es bon
						if(infoOK) {
							if(type.equals("chirurgien")) {
								c.modifierInfos(new Chirurgien(suppl, c.getIdPersonne(), nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, mdp));
							}
							else {
								s.modifierInfos(new Secretaire(suppl, s.getIdPersonne(), nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, mdp));
							}
						}
					}
					else {
						// Gestion d'erreur
						erreurs.add("Mot de passe incorrect");
					}
				}
				// Redirection vers la même page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
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
