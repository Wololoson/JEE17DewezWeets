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

import be.gestionhopital.Models.Directeur;
import be.gestionhopital.Models.ListPatient;
import be.gestionhopital.Models.Patient;
import be.gestionhopital.Models.Secretaire;

/**
 * Servlet implementation class ServletPatient
 */
public class ServletPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Déclaration des variables qui contiennent les URL
	private String urlAccueil;
	private String urlPatient;
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlPatient = (String)config.getInitParameter("urlPatient");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		
		// Actions en fonction de du parametre reçu (submit)
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			ListPatient lp = ListPatient.getInstance();
			
			// Si on modifie les informations d'un patient
			if(paramName.equals("modif")) {
				// Vérification de la sélection d'un patient
				if(request.getParameter("pat") != null) {
					//Revoi des informations nécessaire à la modification sur la JSP
					request.setAttribute("erreurs", erreurs);
					request.setAttribute("lp", lp);
					request.setAttribute("isModif", true);
					request.setAttribute("i",Integer.parseInt(request.getParameter("pat")));
					getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
				}
				else {
					// Gestion d'erreur
					erreurs.add("Veuillez sélectionner un patient");
					request.setAttribute("erreurs", erreurs);
					request.setAttribute("lp", lp);
					request.setAttribute("isModif", false);
					request.setAttribute("i",-1);
					getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
				}
			}
			
			// Validation de la modification
			if(paramName.equals("validModif")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Directeur d = null;
				Secretaire s = null;
				
				// Test du type de la personne cconnectée
				if(type.equals("directeur")) {
					d = (Directeur)sess.getAttribute(type);
				}
				else {
					s = (Secretaire)sess.getAttribute(type);
				}
				
				// Vérification des informations
				boolean resOKModif = true;
				
				String numPati = (String)request.getParameter("numPatientModif");
				String nomPati = (String)request.getParameter("nomPatientModif");
				String prenomPati = (String)request.getParameter("prenomPatientModif");
				String dateNaissPatiJ = (String)request.getParameter("dateNaissJModif");
				String dateNaissPatiM = (String)request.getParameter("dateNaissMModif");
				String dateNaissPatiA = (String)request.getParameter("dateNaissAModif");
				String numTelPati = (String)request.getParameter("numTelPatientModif");
				String numChPati = (String)request.getParameter("numChPatientModif");
				Patient pati = null;
				
				if(!numPati.matches("^[0-9]{5}$")) {
					erreurs.add("Le numéro du patient doit faire 5 caractères et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!nomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le nom du patient doit faire maximum 50 caractères et ne contenir aucun chiffres.");
					resOKModif = false;
				}
				if(!prenomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le prénom du patient doit faire maximum 50 caractères et ne contenir aucun chiffres.");
					resOKModif = false;
				}
				if(!dateNaissPatiJ.matches("^[0-9]{2}$")) {
					erreurs.add("Le jour de la date de naissance de patient doit faire 2 caractères et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!dateNaissPatiM.matches("^[0-9]{2}$")) {
					erreurs.add("Le mois de la date de naissance de patient doit faire 2 caractères et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!dateNaissPatiA.matches("^[0-9]{4}$")) {
					erreurs.add("L'année de la date de naissance de patient doit faire 4 caractères et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!numTelPati.matches("^(0)(\\d){3}(\\/)((\\d){2}(\\.)){2}(\\d){2}$")) {
					erreurs.add("Le numéro de téléphone du patient doit faire au minimum 13 caractères, au maximum 20 caractères et respecter le canvas.");
					resOKModif = false;
				}
				if(!numChPati.matches("^[0-9]{3}$")) {
					erreurs.add("Le numéro de chambre du patient doit faire 3 caractères et ne contenir que des chiffres.");
					resOKModif = false;
				}
				
				//Si tout est OK
				if(resOKModif) {
					pati = new Patient(numChPati, numPati, 0, nomPati, prenomPati, (dateNaissPatiA+"-"+dateNaissPatiM+"-"+dateNaissPatiJ) , numTelPati, "");

					String i = request.getParameter("selected");
					Patient oldPati = (Patient) sess.getAttribute("pati"+i);
					pati.setIdPersonne(oldPati.getIdPersonne());
					
					// Modification
					if(type.equals("directeur"))
						d.modifierPatient(oldPati, pati);
					else {
						s.modifierPatient(oldPati, pati);
					}
				}
				
				// Redirection vers la même page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lp", lp);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
				getServletContext().getRequestDispatcher(urlPatient).forward(request, response);
			}
			if(paramName.equals("retour")) {
				// Redirection vers la page d'accueil
				getServletContext().getRequestDispatcher(urlAccueil).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
