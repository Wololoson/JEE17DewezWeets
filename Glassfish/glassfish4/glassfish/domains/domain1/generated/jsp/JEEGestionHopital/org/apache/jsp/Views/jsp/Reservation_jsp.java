package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Reservation;
import java.util.ArrayList;

public final class Reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t\t<title>Reservations</title>\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../JEEGestionHopital/Views/css/reservation.css\"/>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\twindow.onload = function(){\r\n");
      out.write("\t\t\t\tvar modal = document.getElementById(\"modal\");\r\n");
      out.write("\t\t\t\tvar addBtn = document.getElementById(\"modalDisplay\");\r\n");
      out.write("\t\t\t\tvar close = document.getElementsByClassName(\"close\")[0];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\taddBtn.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"block\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tclose.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\twindow.onclick = function(event) {\r\n");
      out.write("\t\t\t\t    if (event.target == modal) {\r\n");
      out.write("\t\t\t\t        modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"modal\" class=\"modal\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t    \t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t<form action=\"ServletReservation\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tPatient\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numPati\" id=\"numPati\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"nomPati\" id=\"nomPati\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tPrénom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"prenomPati\" id=\"prenomPati\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tDate de naissance :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiJ\" id=\"dateNaissPatiJ\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiM\" id=\"dateNaissPatiM\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiA\" id=\"dateNaissPatiA\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro de téléphone :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numTelPati\" id=\"numTelPati\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro de chambre :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numChPati\" id=\"numChPati\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tSalle\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numSalle\" id=\"numSalle\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tBloc :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"blocSalle\" id=\"blocSalle\" value=\"\" size=\"20\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tDate et heure\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"heureResH\" id=\"heureResH\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t\t:\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"heureResM\" id=\"heureResM\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResJ\" id=\"dateResJ\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t\t/\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResM\" id=\"dateResM\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t\t/\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResA\" id=\"dateResA\" value=\"\" size=\"3\" required=\"required\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"ajout\" id=\"ajout\" value=\"Valider\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>Gestion les réservations</h1>\r\n");
      out.write("\t\t");

			HttpSession sess = request.getSession();
			String type = (String) sess.getAttribute("type");
			Personne p = (Personne) sess.getAttribute(type);
			ArrayList<Reservation> lr = (ArrayList<Reservation>) request.getAttribute("lr");
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"ServletReservation\" method=\"post\">\r\n");
      out.write("\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");
 if(type.equals("secretaire") || type.equals("directeur")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\tChirurgien\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t<th colspan=\"5\">\r\n");
      out.write("\t\t\t\t\t\tPatient\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\tSalle d'opération\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\tDate et heure\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");
 if(type.equals("secretaire") || type.equals("directeur")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tNom\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tPrenom\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tSpécialisation\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tNuméro\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tNom\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tPrénom\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tTéléphone\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tChambre\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tNuméro\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tBloc\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					for(Reservation r : lr){
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t");
if(type.equals("secretaire") || type.equals("directeur")){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getChirurgien().getNom();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getChirurgien().getPrenom();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getChirurgien().getSpecialisation();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getPatient.getNumPatient();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getPatient.getNom();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getPatient.getPrenom();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getPatient.getNumTelephone();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getPatient.getNumChambre();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getSalle().getNumSalle();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getSalle().getBloc();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tr.getDateHeure();\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"res\" value=\"");
      out.print(r);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t");
}
						else{
							if(p.equals(r.getChirurgien())){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getPatient.getNumPatient();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getPatient.getNom();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getPatient.getPrenom();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getPatient.getNumTelephone();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getPatient.getNumChambre();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getSalle().getNumSalle();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getSalle().getBloc();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tr.getDateHeure();\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"res\" value=\"");
      out.print(r);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
						}
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t");
if(type.equals("secretaire") || type.equals("chirurgien")){
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"modalDisplay\" id=\"modalDisplay\" value=\"Ajouter\"/>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"modif\" id=\"modif\" value=\"Modifier\"/>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"suppr\" id=\"suppr\" value=\"Supprimer\"/>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"retour\" id=\"retour\" value=\"Retour\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
