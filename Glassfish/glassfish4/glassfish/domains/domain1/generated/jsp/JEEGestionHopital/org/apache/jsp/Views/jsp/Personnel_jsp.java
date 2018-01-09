package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.Secretaire;
import be.gestionhopital.Models.ListPersonnel;
import java.util.ArrayList;

public final class Personnel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t\t<title>Personnel</title>\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../JEEGestionHopital/Views/css/personnel.css\"/>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\twindow.onload = function(){\r\n");
      out.write("\t\t\t\tvar modal = document.getElementById(\"modal\");\r\n");
      out.write("\t\t\t\tvar addBtn = document.getElementById(\"modalDisplay\");\r\n");
      out.write("\t\t\t\tvar addClose = document.getElementsByClassName(\"close\")[0];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\taddBtn.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"block\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\taddClose.onclick = function() {\r\n");
      out.write("\t\t\t\t    modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\twindow.onclick = function(event) {\r\n");
      out.write("\t\t\t\t    if (event.target == modal) {\r\n");
      out.write("\t\t\t\t        modal.style.display = \"none\";\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction supplDisplay(i){\r\n");
      out.write("\t\t\t\tvar spec = document.getElementById(\"spec_tr\");\r\n");
      out.write("\t\t\t\tvar serv = document.getElementById(\"serv_tr\");\r\n");
      out.write("\t\t\t\tvar spec_input = document.getElementById(\"spec\");\r\n");
      out.write("\t\t\t\tvar serv_input = document.getElementById(\"serv\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(i == 0){\r\n");
      out.write("\t\t\t\t\tspec.style.display = \"table-row\";\r\n");
      out.write("\t\t\t\t\tspec_input.required = true;\r\n");
      out.write("\t\t\t\t\tserv.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\tserv_input.required = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\tspec.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\tspec_input.required = false;\r\n");
      out.write("\t\t\t\t\tserv.style.display = \"table-row\";\r\n");
      out.write("\t\t\t\t\tserv_input.required = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<h1>Gestion du personnel</h1>\r\n");
      out.write("\t");

		HttpSession sess = request.getSession();
		String type = (String) sess.getAttribute("type");
		Personne p = (Personne) sess.getAttribute(type);
		ListPersonnel lp = (ListPersonnel) request.getAttribute("lp");
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
		int i = 0;
		int j = 0;
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"modal\" class=\"modal\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t    \t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t<form action=\"ServletPersonnel\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\tType\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"listPers\" name=\"listPers\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"chirurgien\" onclick=\"supplDisplay(0)\">Chirurgien</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"secretaire\" onclick=\"supplDisplay(1)\">Secrétaire</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\tInformations\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"nom\" id=\"nom\" value=\"\" size=\"20\" required=\"required\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tPrénom :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"prenom\" id=\"prenom\" value=\"\" size=\"20\" required=\"required\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tDate de naissance :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissJ\" id=\"dateNaissJ\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissM\" id=\"dateNaissM\" value=\"\" size=\"3\" required=\"required\" maxlength=\"2\" placeholder=\"01\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"dateNaissA\" id=\"dateNaissA\" value=\"\" size=\"3\" required=\"required\" maxlength=\"4\" placeholder=\"2000\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tNuméro de téléphone :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"numTel\" id=\"numTel\" value=\"\" size=\"20\" required=\"required\" maxlength=\"20\" placeholder=\"0123/45.67.89\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr id=\"spec_tr\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tSpécialisation :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"spec\" id=\"spec\" value=\"\" size=\"20\" required=\"required\" maxlength=\"30\" placeholder=\"\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr id=\"serv_tr\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tService :\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"serv\" id=\"serv\" value=\"\" size=\"20\" maxlength=\"30\" placeholder=\"\" />\r\n");
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
      out.write("\t<form action=\"ServletPersonnel\" method=\"post\">\r\n");
      out.write("\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th colspan=\"6\">\r\n");
      out.write("\t\t\t\t\tChirurgien\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tNom\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tPrénom\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tDate de naissance\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tNuméro de téléphone\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tSpécialisation\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				for(Chirurgien c : lp.getListChirurgien()){
						sess.setAttribute("chir"+Integer.toString(i), c);
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getDateNaiss() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getSpecialisation() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" id=\"chir\" name=\"chir\" value=\"");
      out.print(i );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

					i++;
				}
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th colspan=\"6\">\r\n");
      out.write("\t\t\t\t\tSecretaire\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tNom\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tPrénom\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tDate de naissance\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tNuméro de téléphone\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tService\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				for(Secretaire s : lp.getListSecretaire()){
						sess.setAttribute("secr"+Integer.toString(i), s);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(s.getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(s.getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(s.getDateNaiss() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(s.getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(s.getService() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"secr\" name=\"secr\" value=\"");
      out.print(i );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

					i++;
				}
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<input type=\"button\" name=\"modalDisplay\" id=\"modalDisplay\" value=\"Ajouter\"/>\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"suppr\" id=\"suppr\" value=\"Supprimer\"/>\r\n");
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
