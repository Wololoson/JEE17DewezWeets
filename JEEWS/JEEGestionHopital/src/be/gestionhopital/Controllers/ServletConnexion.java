package be.gestionhopital.Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.ListPersonnel;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Secretaire;

/**
 * Servlet implementation class ServletConnexion
 */
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// D�claration des variables qui contiennent les URL
	private String urlValid = null;
	private String urlConnexion = null;
	
	// Initialisation des variables qui contiennent les URL
	public void init() {
		ServletConfig config = getServletConfig();
		urlValid = (String)config.getInitParameter("urlValid");
		urlConnexion = (String)config.getInitParameter("urlConnexion");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// D�claration des variables locales
		String idPers = request.getParameter("listPers");
		String motDePasse = request.getParameter("motDePasse");
		String code = request.getParameter("code");
		String type = null;
		boolean mdpOK = false;
		boolean codeOK = false;
		ListPersonnel lp = ListPersonnel.getInstance();
		Personne connected = null;
		
		ArrayList<String> erreursParametres = new ArrayList<String>();
		
		//V�rification des informations entr�es
		if(idPers == null) 
			erreursParametres.add("Veuillez choisir votre identifiant.");
		
		if(motDePasse == null) 
			erreursParametres.add("Veuillez indiquer un mot de passe.");
		
		else if(motDePasse.equals("")) 
			erreursParametres.add("Veuillez indiquer un mot de passe.");
		
		if(!motDePasse.matches("^[0-9a-zA-Z]{6,}$"))
			erreursParametres.add("Le mot de passe doit contenir au moins 6 caract�res.");
		
		// Si la personne est un chirurgien
		for(Chirurgien c : lp.getListChirurgien()) {
			if(idPers != null && idPers.equals(Integer.toString(c.getIdPersonne()))) {
				if(motDePasse != null && motDePasse.equals(c.getMotDePasse())) {
					mdpOK = true;
					codeOK = true;
					connected = c;
					type = "chirurgien";
				}
			}
		}
		
		// Si la personne est un secr�taire
		for(Secretaire s : lp.getListSecretaire()) {
			if(idPers != null && idPers.equals(Integer.toString(s.getIdPersonne()))) {
				if(motDePasse != null && motDePasse.equals(s.getMotDePasse())) {
					mdpOK = true;
					codeOK = true;
					connected = s;
					type = "secretaire";
				}
			}
		}
		
		// Si la personne est le directeur
		if(idPers != null && idPers.equals("dire")) {
			if(motDePasse != null && motDePasse.equals(lp.getDirecteur().getMotDePasse())) {
				mdpOK = true;
				if(code != null && code.equals(lp.getDirecteur().getCode())) {
					codeOK = true;
					connected = lp.getDirecteur();
					type = "directeur";
				}
			}
		}
		
		// Tout est valid�
		if(mdpOK && codeOK) {
			if(urlValid == null) 
				throw new ServletException("URL de validation � null");
			else {
				// Incription des informations importantes dans la session
				HttpSession sess = request.getSession();
		
				if(connected != null) {
					sess.setAttribute("type",type);
					sess.setAttribute(type, connected);
					
					// Redirection vers l'accueil
					getServletContext().getRequestDispatcher(urlValid).forward(request, response);
				}
				else
					throw new ServletException("Personne connect�e � null");
			}
		}
		else {
			// Gestion des erreurs
			if(!mdpOK)
				erreursParametres.add("Mot de passe incorrect.");
			if(!codeOK)
				erreursParametres.add("Code incorrect.");
		}
		
		if(erreursParametres.size() > 0) {
			// Redirection vers la m�me page en cas d'erreur
			request.setAttribute("erreurs", erreursParametres);
			
			getServletContext().getRequestDispatcher(urlConnexion).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
