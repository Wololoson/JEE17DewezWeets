package be.gestionhopital.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOChirurgien;
import be.gestionhopital.Factory.AbstractDAOFactory;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.ListReservation;
import be.gestionhopital.Models.Notification;
import be.gestionhopital.Models.Patient;
import be.gestionhopital.Models.Reservation;
import be.gestionhopital.Models.Salle;
import be.gestionhopital.Models.Secretaire;

/**
 * Servlet implementation class ServletReservation
 */
public class ServletReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// D�claration des variables qui contiennent les URL
	private String urlAccueil, urlReservation;
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlReservation = (String)config.getInitParameter("urlReservation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		
		// Actions en fonction de du parametre re�u (submit)
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			ListReservation lr = ListReservation.getInstance();
			
			// Si on ajoute une r�servation
			if(paramName.equals("ajout")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = null;
				Secretaire s = null;
				
				// Test du type de la personne connect�e
				if(type.equals("chirurgien")) {
					c = (Chirurgien)sess.getAttribute(type);
				}
				else {
					String idChir = (String)request.getParameter("listChir");
					DAOChirurgien chirurgienDAO = (DAOChirurgien)adf.getChirurgienDAO();
					s = (Secretaire)sess.getAttribute(type);
					
					try {
						c = (Chirurgien)chirurgienDAO.find(Integer.parseInt(idChir));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SAXException e) {
						e.printStackTrace();
					}
				}
				
				// V�rification des informations
				boolean resOK = true;
				
				String numPati = (String)request.getParameter("numPati");
				String nomPati = (String)request.getParameter("nomPati");
				String prenomPati = (String)request.getParameter("prenomPati");
				String dateNaissPatiJ = (String)request.getParameter("dateNaissPatiJ");
				String dateNaissPatiM = (String)request.getParameter("dateNaissPatiM");
				String dateNaissPatiA = (String)request.getParameter("dateNaissPatiA");
				String numTelPati = (String)request.getParameter("numTelPati");
				String numChPati = (String)request.getParameter("numChPati");
				Patient pati = null;
				
				if(!numPati.matches("^[0-9]{5}$")) {
					erreurs.add("Le num�ro du patient doit faire 5 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!nomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le nom du patient doit faire maximum 50 caract�res et ne contenir aucun chiffres.");
					resOK = false;
				}
				if(!prenomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le pr�nom du patient doit faire maximum 50 caract�res et ne contenir aucun chiffres.");
					resOK = false;
				}
				if(!dateNaissPatiJ.matches("^[0-9]{2}$")) {
					erreurs.add("Le jour de la date de naissance de patient doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!dateNaissPatiM.matches("^[0-9]{2}$")) {
					erreurs.add("Le mois de la date de naissance de patient doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!dateNaissPatiA.matches("^[0-9]{4}$")) {
					erreurs.add("L'ann�e de la date de naissance de patient doit faire 4 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!numTelPati.matches("^(0)(\\d){3}(\\/)((\\d){2}(\\.)){2}(\\d){2}$")) {
					erreurs.add("Le num�ro de t�l�phone du patient doit faire au minimum 13 caract�res, au maximum 20 caract�res et respecter le canvas.");
					resOK = false;
				}
				if(!numChPati.matches("^[0-9]{3}$")) {
					erreurs.add("Le num�ro de chambre du patient doit faire 3 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				
				String numSalle = (String)request.getParameter("numSalle");
				String blocSalle = (String)request.getParameter("blocSalle");
				Salle salle = null;
				
				if(!numSalle.matches("^[0-9]{2}$")) {
					erreurs.add("Le num�ro de la salle d'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!blocSalle.matches("^[A-Z]$")) {
					erreurs.add("Le bloc dans lequel se trouve la salle d'op�ration ne doit faire qu'un seul caract�re en majuscule.");
					resOK = false;
				}
				
				String heureResH = (String)request.getParameter("heureResH");
				String heureResM = (String)request.getParameter("heureResM");				
				String dateResJ = (String)request.getParameter("dateResJ");
				String dateResM = (String)request.getParameter("dateResM");
				String dateResA = (String)request.getParameter("dateResA");
				Reservation res = null;
				
				if(!heureResH.matches("^[0-9]{2}$")) {
					erreurs.add("L'heure de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!heureResM.matches("^[0-9]{2}$")) {
					erreurs.add("Les minutes de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!dateResJ.matches("^[0-9]{2}$")) {
					erreurs.add("Le jour de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!dateResM.matches("^[0-9]{2}$")) {
					erreurs.add("Le mois de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				if(!dateResA.matches("^[0-9]{4}$")) {
					erreurs.add("L'ann�e de la date de l'op�ration doit faire 4 caract�res et ne contenir que des chiffres.");
					resOK = false;
				}
				
				String priorite = (String)request.getParameter("listPrio");
				String commentaire = (String)request.getParameter("commentaire");
				
				if(type.equals("secretaire")) {
					if(!commentaire.matches("^[a-zA-Z0-9]{1,300}$")) {
						erreurs.add("Le nom du patient doit faire maximum 300 caract�res.");
						resOK = false;
					}
				}
				
				// Si tout est OK
				if(resOK) {
					pati = new Patient(numChPati, numPati, 0, nomPati, prenomPati, (dateNaissPatiA+"-"+dateNaissPatiM+"-"+dateNaissPatiJ), numTelPati, "");
					salle = new Salle(0, numSalle, blocSalle.charAt(0));
					res = new Reservation(0, c, salle, pati, Date.valueOf(dateResA+"-"+dateResM+"-"+dateResJ), heureResH+":"+heureResM);
					
					// Ajout en fonction du type
					if(type.equals("chirurgien"))
						c.ajouterReservation(res);
					else {
						s.ajouterReservation(res, new Notification(0, Integer.parseInt(priorite), 1, commentaire, c));
					}
				}
				// Redirection vers la m�me page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
				getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
			}
			
			// Si on modifie une r�servation
			if(paramName.equals("modif")) {
				// V�rification de la connexion
				if(request.getParameter("res") != null) {
					// Attribution des valeurs ad�quates � la requ�te et redirection vers la m�me page
					request.setAttribute("erreurs", erreurs);
					request.setAttribute("lr", lr);
					request.setAttribute("isModif", true);
					request.setAttribute("i",Integer.parseInt(request.getParameter("res")));
					getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
				}
				else {
					//Gestion d'erreur et redirection vers la m�me page
					erreurs.add("Veuillez s�lectionner une r�servation");
					request.setAttribute("erreurs", erreurs);
					request.setAttribute("lr", lr);
					request.setAttribute("isModif", false);
					request.setAttribute("i",-1);
					getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
				}
			}
			
			// Si on valide la modification
			if(paramName.equals("validModif")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = null;
				Secretaire s = null;
				
				// Test du type de la personne connect�e
				if(type.equals("chirurgien")) {
					c = (Chirurgien)sess.getAttribute(type);
				}
				else {
					String idChir = (String)request.getParameter("listChirModif");
					DAOChirurgien chirurgienDAO = (DAOChirurgien)adf.getChirurgienDAO();
					s = (Secretaire)sess.getAttribute(type);
					
					try {
						c = (Chirurgien)chirurgienDAO.find(Integer.parseInt(idChir));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SAXException e) {
						e.printStackTrace();
					}
				}
				
				// V�rification des informations
				boolean resOKModif = true;
				
				String numPati = (String)request.getParameter("numPatientModif");
				String nomPati = (String)request.getParameter("nomPatientModif");
				String prenomPati = (String)request.getParameter("prenomPatientModif");
				String numTelPati = (String)request.getParameter("numTelPatientModif");
				String numChPati = (String)request.getParameter("numChPatientModif");
				Patient pati = null;
				
				if(!numPati.matches("^[0-9]{5}$")) {
					erreurs.add("Le num�ro du patient doit faire 5 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!nomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le nom du patient doit faire maximum 50 caract�res et ne contenir aucun chiffres.");
					resOKModif = false;
				}
				if(!prenomPati.matches("^[a-zA-Z]{1,50}$")) {
					erreurs.add("Le pr�nom du patient doit faire maximum 50 caract�res et ne contenir aucun chiffres.");
					resOKModif = false;
				}
				if(!numTelPati.matches("^(0)(\\d){3}(\\/)((\\d){2}(\\.)){2}(\\d){2}$")) {
					erreurs.add("Le num�ro de t�l�phone du patient doit faire au minimum 13 caract�res, au maximum 20 caract�res et respecter le canvas.");
					resOKModif = false;
				}
				if(!numChPati.matches("^[0-9]{3}$")) {
					erreurs.add("Le num�ro de chambre du patient doit faire 3 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				
				String numSalle = (String)request.getParameter("numSalleModif");
				String blocSalle = (String)request.getParameter("blocSalleModif");
				Salle salle = null;
				
				if(!numSalle.matches("^[0-9]{2}$")) {
					erreurs.add("Le num�ro de la salle d'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!blocSalle.matches("^[A-Z]$")) {
					erreurs.add("Le bloc dans lequel se trouve la salle d'op�ration ne doit faire qu'un seul caract�re en majuscule.");
					resOKModif = false;
				}
				
				String heureResH = (String)request.getParameter("heureResHModif");
				String heureResM = (String)request.getParameter("heureResMModif");				
				String dateResJ = (String)request.getParameter("dateResJModif");
				String dateResM = (String)request.getParameter("dateResMModif");
				String dateResA = (String)request.getParameter("dateResAModif");
				Reservation res = null;
				
				if(!heureResH.matches("^[0-9]{2}$")) {
					erreurs.add("L'heure de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!heureResM.matches("^[0-9]{2}$")) {
					erreurs.add("Les minutes de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!dateResJ.matches("^[0-9]{2}$")) {
					erreurs.add("Le jour de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!dateResM.matches("^[0-9]{2}$")) {
					erreurs.add("Le mois de la date de l'op�ration doit faire 2 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				if(!dateResA.matches("^[0-9]{4}$")) {
					erreurs.add("L'ann�e de la date de l'op�ration doit faire 4 caract�res et ne contenir que des chiffres.");
					resOKModif = false;
				}
				
				String priorite = (String)request.getParameter("listPrioModif");
				String commentaire = (String)request.getParameter("commentaireModif");
				
				if(type.equals("secretaire")) {
					if(!commentaire.matches("^[a-zA-Z0-9]{1,300}$")) {
						erreurs.add("Le nom du patient doit faire maximum 300 caract�res.");
						resOKModif = false;
					}
				}
				
				
				// Si tout est OK
				if(resOKModif) {
					pati = new Patient(numChPati, numPati, 0, nomPati, prenomPati, null , numTelPati, "");
					salle = new Salle(0, numSalle, blocSalle.charAt(0));
					res = new Reservation(0, c, salle, pati, Date.valueOf(dateResA+"-"+dateResM+"-"+dateResJ), heureResH+":"+heureResM);
					
					String i = request.getParameter("selected");
					Reservation oldRes = (Reservation) sess.getAttribute(i);
					res.setIdReservation(oldRes.getIdReservation());
					res.getPatient().setDateNaiss(oldRes.getPatient().getDateNaiss());
					res.getPatient().setIdPersonne(oldRes.getPatient().getIdPersonne());
					res.getSalle().setIdSalle(oldRes.getSalle().getIdSalle());
					
					// Modification en fonction du type
					if(type.equals("chirurgien"))
						c.modifierReservation(oldRes, res);
					else {
						s.modifierReservation(oldRes, res, new Notification(0, Integer.parseInt(priorite), 2, commentaire, c));
					}
				}
				// Redirection vers la m�me page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
				getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
			}
			
			// Si on supprime
			if(paramName.equals("validSuppr")) {
				// V�rification de la s�lection
				if(request.getParameter("res") != null || request.getParameter("resSuppr") != null) {
					HttpSession sess = request.getSession();
					String type = (String) sess.getAttribute("type");
					Chirurgien c = null;
					Secretaire s = null;
					Reservation delRes = null;
					
					// Test du type de la personne connect�e
					if(type.equals("chirurgien")) {
						c = (Chirurgien)sess.getAttribute(type);
						delRes = (Reservation) sess.getAttribute(request.getParameter("res"));
					}
					else {
						s = (Secretaire)sess.getAttribute(type);
						delRes = (Reservation) sess.getAttribute(request.getParameter("resSuppr"));
						c = delRes.getChirurgien();
					}
					
					// V�rification des informations
					boolean resOKSuppr = true;
					
					String priorite = (String)request.getParameter("listPrioSuppr");
					String commentaire = (String)request.getParameter("commentaireSuppr");
					
					if(type.equals("secretaire")) {
						if(!commentaire.matches("^[a-zA-Z0-9]{1,300}$")) {
							erreurs.add("Le nom du patient doit faire maximum 300 caract�res.");
							resOKSuppr = false;
						}
					}
					
					// Si tout est OK
					if(resOKSuppr) {
						// Suppression en fonction du type
						if(type.equals("chirurgien"))
							c.supprimerReservation(delRes);
						else {
							s.supprimerReservation(delRes, new Notification(0, Integer.parseInt(priorite), 3, commentaire, c));
						}
					}
				}
				else {
					// Gestion d'erreur
					erreurs.add("Veuillez s�lectionner une r�servation");
				}
				// Redirection vers la m�me page dans tous les cas
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("lr", lr);
				request.setAttribute("isModif", false);
				request.setAttribute("i",-1);
				getServletContext().getRequestDispatcher(urlReservation).forward(request, response);
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
