package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.ListPersonnel;
import be.gestionhopital.Models.ListReservation;
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
      out.write("\t\t\t\tvar addClose = document.getElementsByClassName(\"close\")[0];\r\n");
      out.write("\t\t\t\tvar modalSuppr = document.getElementById(\"modalSuppr\");\r\n");
      out.write("\t\t\t\tvar delBtn = document.getElementById(\"supprDisplay\");\r\n");
      out.write("\t\t\t\tvar delClose = document.getElementsByClassName(\"close\")[1];\r\n");
      out.write("\t\t\t\tvar resSuppr = document.getElementById(\"resSuppr\");\r\n");
      out.write("\t\t\t\tvar radios = document.getElementsByClassName(\"res\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\taddBtn.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"block\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\taddClose.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tdelClose.onclick = function() {\r\n");
      out.write("\t\t\t\t    modalSuppr.style.display = \"none\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\twindow.onclick = function(event) {\r\n");
      out.write("\t\t\t\t    if (event.target == modal) {\r\n");
      out.write("\t\t\t\t        modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t    if (event.target == modalSuppr) {\r\n");
      out.write("\t\t\t\t        modalSuppr.style.display = \"none\";\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tdelBtn.onclick = function(){\r\n");
      out.write("\t\t\t\t\tmodalSuppr.style.display = \"block\";\r\n");
      out.write("\t\t\t\t\tfor(var i = 0; i < radios.length; i++){\r\n");
      out.write("\t\t\t\t\t\tvar btn = radios[i];\r\n");
      out.write("\t\t\t\t\t\tif(btn.checked){\r\n");
      out.write("\t\t\t\t\t\t\tresSuppr.value = btn.value;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<h1>Gestion les réservations</h1>\r\n");
      out.write("\t\t");

			HttpSession sess = request.getSession();
			String type = (String) sess.getAttribute("type");
			Personne p = (Personne) sess.getAttribute(type);
			ListReservation lr = (ListReservation) request.getAttribute("lr");
			ListPersonnel lp = ListPersonnel.getInstance();
			boolean isModif = (Boolean) request.getAttribute("isModif");
			int selected = (Integer) request.getAttribute("i");
			int i = 0;
			ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"modal\" class=\"modal\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t    \t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t<form action=\"ServletReservation\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\tChirurgien\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t");
 if(type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"listChir\" name=\"listChir\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 
									for(Chirurgien c : lp.getListChirurgien()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(c.getIdPersonne());
      out.write('"');
      out.write('>');
      out.print(c.getNom());
      out.write(' ');
      out.print(c.getPrenom());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

									}
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
							else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getNom() );
      out.write(' ');
      out.print(p.getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
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
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numPati\" id=\"numPati\" value=\"\" size=\"20\" required=\"required\" maxlength=\"5\" placeholder=\"12345\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"nomPati\" id=\"nomPati\" value=\"\" size=\"20\" required=\"required\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tPrénom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"prenomPati\" id=\"prenomPati\" value=\"\" size=\"20\" required=\"required\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tDate de naissance :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiJ\" id=\"dateNaissPatiJ\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiM\" id=\"dateNaissPatiM\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissPatiA\" id=\"dateNaissPatiA\" value=\"\" size=\"3\" required=\"required\" maxlength=\"4\" placeholder=\"2000\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro de téléphone :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numTelPati\" id=\"numTelPati\" value=\"\" size=\"20\" required=\"required\" maxlength=\"20\" placeholder=\"0123/45.67.89\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro de chambre :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numChPati\" id=\"numChPati\" value=\"\" size=\"20\" required=\"required\" maxlength=\"3\" placeholder=\"001\" />\r\n");
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
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numSalle\" id=\"numSalle\" value=\"\" size=\"20\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tBloc :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"blocSalle\" id=\"blocSalle\" value=\"\" size=\"20\" required=\"required\" maxlength=\"1\" placeholder=\"A\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tDate et heure\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"heureResH\" id=\"heureResH\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t:\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"heureResM\" id=\"heureResM\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"00\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResJ\" id=\"dateResJ\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t/\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResM\" id=\"dateResM\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t/\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateResA\" id=\"dateResA\" value=\"\" size=\"3\" required=\"required\" maxlength=\"4\" placeholder=\"2000\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 if(type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\tNotification\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tPriorité\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select  id=\"listPrio\" name=\"listPrio\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tCommentaire\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea id=\"comm\" name=\"commentaire\" cols=\"20\" rows=\"3\" maxlength=\"300\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
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
      out.write("\t<div id=\"modalSuppr\" class=\"modal\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t    \t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t<form action=\"ServletReservation\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tNotification\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tPriorité\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select  id=\"listPrioSuppr\" name=\"listPrioSuppr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tCommentaire\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"commentaireSuppr\" name=\"commentaireSuppr\" cols=\"20\" rows=\"3\" maxlength=\"300\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"resSuppr\" id=\"resSuppr\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"validSuppr\" id=\"validSuppr\" value=\"Valider\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"ServletReservation\" method=\"post\">\r\n");
      out.write("\t\t\t<table id=\"resTab\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
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
      out.write("\t\t\t\t\t<th rowspan=\"2\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\tDate et heure\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t");
 if(type.equals("chirurgien") || type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
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

					for(Reservation r : lr.getListReservation()){
						if(isModif && i == selected){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
 if(type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t            <select id=\"listChirModif\" name=\"listChirModif\">\r\n");
      out.write("\t\t\t\t\t\t                ");
 for(Chirurgien c : lp.getListChirurgien()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t                    <option value=\"");
      out.print(c.getIdPersonne());
      out.write('"');
      out.write('>');
      out.print(c.getNom());
      out.write(' ');
      out.print(c.getPrenom());
      out.write(' ');
      out.print(c.getSpecialisation());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t                ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t            </select>\r\n");
      out.write("\t\t\t\t\t\t        </td>\r\n");
      out.write("\t\t\t\t\t\t    ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numPatientModif\" name=\"numPatientModif\" value=\"");
      out.print(r.getPatient().getNumPatient() );
      out.write("\" required size=\"20\" maxlength=\"5\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"nomPatientModif\" name=\"nomPatientModif\" value=\"");
      out.print(r.getPatient().getNom() );
      out.write("\" required size=\"20\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"prenomPatientModif\" name=\"prenomPatientModif\" value=\"");
      out.print(r.getPatient().getPrenom() );
      out.write("\" required size=\"20\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numTelPatientModif\" name=\"numTelPatientModif\" value=\"");
      out.print(r.getPatient().getNumTelephone() );
      out.write("\" required size=\"20\" maxlength=\"20\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numChPatientModif\" name=\"numChPatientModif\" value=\"");
      out.print(r.getPatient().getNumChambre() );
      out.write("\" required size=\"20\" maxlength=\"3\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numSalleModif\" name=\"numSalleModif\" value=\"");
      out.print(r.getSalle().getNumSalle() );
      out.write("\" required size=\"20\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"blocSalleModif\" name=\"blocSalleModif\" value=\"");
      out.print(r.getSalle().getBloc() );
      out.write("\" required size=\"20\" maxlength=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t    \t");

						    		String date = r.getDateRes().toString();
							    	int premierTiret = date.indexOf("-");
									int deuxiemeTiret = date.indexOf('-', premierTiret+1);
									String annee = date.substring(0,premierTiret);
									String mois = date.substring(premierTiret+1,deuxiemeTiret);
									String jour = date.substring(deuxiemeTiret+1);
						    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateResJModif\" name=\"dateResJModif\" value=\"");
      out.print(jour );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t        /\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateResMModif\" name=\"dateResMModif\" value=\"");
      out.print(mois );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t        /\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateResAModif\" name=\"dateResAModif\" value=\"");
      out.print(annee );
      out.write("\" required size=\"3\" maxlength=\"4\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t    \t");

						    		String heure = r.getHeureRes();
							    	int deuxPoints = heure.indexOf(":");
									String h = heure.substring(0,deuxPoints);
									String m = heure.substring(deuxPoints+1);
						    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"heureResHModif\" name=\"heureResHModif\" value=\"");
      out.print(h );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t        :\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"heureResMModif\" name=\"heureResMModif\" value=\"");
      out.print(m );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    ");
if(type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select  id=\"listPrioModif\" name=\"listPrioModif\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea id=\"commentaireModif\" name=\"commentaireModif\" cols=\"20\" rows=\"15\" maxlength=\"300\" required></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t    \t<input type=\"hidden\" name=\"selected\" id=\"selected\" value=\"");
      out.print(selected );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"submit\" name=\"validModif\" id=\"validModif\" value=\"Valider\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
}
						else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
if(type.equals("secretaire")){
							sess.setAttribute(Integer.toString(i), r);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getSpecialisation() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumPatient() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumChambre() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getNumSalle() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getBloc() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getDateRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getHeureRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"res\" name=\"res\" value=\"");
      out.print(i );
      out.write("\" class=\"res\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
							else if(type.equals("directeur")){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getChirurgien().getSpecialisation() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumPatient() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumChambre() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getNumSalle() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getBloc() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getDateRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(r.getHeureRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t");
} else{
								if(p.getIdPersonne() == r.getChirurgien().getIdPersonne()){
								sess.setAttribute(Integer.toString(i), r);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumPatient() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getPatient().getNumChambre() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getNumSalle() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getSalle().getBloc() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getDateRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(r.getHeureRes() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"res\" name=\"res\" value=\"");
      out.print(i);
      out.write("\" class=\"res\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
}
							}
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
}
					 	i++;
					}
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t");
if(type.equals("secretaire") || type.equals("chirurgien")){
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"modalDisplay\" id=\"modalDisplay\" value=\"Ajouter\"/>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"modif\" id=\"modif\" value=\"Modifier\"/>\r\n");
      out.write("\t\t\t\t");
if(type.equals("secretaire")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" name=\"supprDisplay\" id=\"supprDisplay\" value=\"Supprimer\"/>\r\n");
      out.write("\t\t\t\t");
}
				else {
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"validSuppr\" id=\"validSuppr\" value=\"Supprimer\"/>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"retour\" id=\"retour\" value=\"Retour\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<ul style=\"color:RED\">\r\n");
      out.write("\t\t");

			if(erreurs != null){
				for (String s : erreurs) {
		
      out.write("\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t");
      out.print(s );
      out.write("\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t");
	
				}
			}
		
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
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
