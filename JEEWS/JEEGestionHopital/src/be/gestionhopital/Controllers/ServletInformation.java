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
	private String urlAccueil = null;
	private String urlInformation = null;
	
	public void init() {
		ServletConfig config = getServletConfig();
		urlAccueil = (String)config.getInitParameter("urlAccueil");
		urlInformation = (String)config.getInitParameter("urlInformation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		ArrayList<String> erreurs = new ArrayList<>();
		
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			
			if(paramName.equals("valider")) {
				HttpSession sess = request.getSession();
				String type = (String) sess.getAttribute("type");
				Chirurgien c = null;
				Secretaire s = null;
				String oldMdp = null;
				
				if(type.equals("chirurgien")) {
					c = (Chirurgien)sess.getAttribute(type);
					oldMdp = c.getMotDePasse();
				}
				else {
					s = (Secretaire)sess.getAttribute(type);
					oldMdp = s.getMotDePasse();
				}
				
				String mdp = (String)request.getParameter("motDePasse");
				
				if(mdp != null && mdp != "") {
					if(mdp.equals(oldMdp)) {
						String nom = (String)request.getParameter("nom");
						String prenom = (String)request.getParameter("prenom");
						String dateNaissJ = (String)request.getParameter("dateNaissJ");
						String dateNaissM = (String)request.getParameter("dateNaissM");
						String dateNaissA = (String)request.getParameter("dateNaissA");
						String numTel = (String)request.getParameter("numTel");
						String suppl = null;
						
						if(type.equals("chirurgien")) {
							suppl = (String)request.getParameter("specialisation");
							
							c.modifierInfos(new Chirurgien(suppl, c.getIdPersonne(), nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, mdp));
						}
						else {
							suppl = (String)request.getParameter("service");
							
							s.modifierInfos(new Secretaire(suppl, s.getIdPersonne(), nom, prenom, dateNaissA+"-"+dateNaissM+"-"+dateNaissJ, numTel, mdp));
						}
					}
					else {
						erreurs.add("Mot de passe incorrect");
					}
				}
				request.setAttribute("erreurs", erreurs);
				getServletContext().getRequestDispatcher(urlInformation).forward(request, response);
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
