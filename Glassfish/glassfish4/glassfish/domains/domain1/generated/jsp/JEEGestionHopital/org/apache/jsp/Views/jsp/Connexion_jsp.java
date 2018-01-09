package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.ListPersonnel;
import be.gestionhopital.Models.Secretaire;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.Directeur;
import java.util.ArrayList;

public final class Connexion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Connexion</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction direCodeDisplay(i){\r\n");
      out.write("\t\tvar direCode = document.getElementById(\"direCode\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(i == 0)\r\n");
      out.write("\t\t\tdireCode.style.display = \"none\";\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\tdireCode.style.display = \"table-row\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		ListPersonnel lp = ListPersonnel.getInstance();
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
	
      out.write("\r\n");
      out.write("\t<h1>Connexion</h1>\r\n");
      out.write("\t<form action=\"ServletConnexion\" method=\"post\">\r\n");
      out.write("\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Identifiant :</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<select id=\"listPers\" name=\"listPers\">\r\n");
      out.write("\t\t\t\t\t\t");
 
						for(Chirurgien c : lp.getListChirurgien()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(c.getIdPersonne());
      out.write("\" onclick=\"direCodeDisplay(0)\">");
      out.print(c.getNom());
      out.write(' ');
      out.print(c.getPrenom());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						for(Secretaire s : lp.getListSecretaire()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(s.getIdPersonne());
      out.write("\" onclick=\"direCodeDisplay(0)\">");
      out.print(s.getNom());
      out.write(' ');
      out.print(s.getPrenom());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"dire\" onclick=\"direCodeDisplay(1)\">");
      out.print(lp.getDirecteur().getNom() );
      out.write(' ');
      out.print(lp.getDirecteur().getPrenom() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Mot de passe :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"motDePasse\" id=\"motDePasse\" value=\"\" size=\"20\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr id=\"direCode\" style=\"display: none\">\r\n");
      out.write("\t\t\t\t<td>Code :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"code\" id=\"code\" value=\"\" size=\"20\" maxlength=\"4\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"connect\" id=\"connect\" value=\"Se connecter\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<ul style=\"color:RED\">\r\n");
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
      out.write("\t</ul>\r\n");
      out.write("</body>\r\n");
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
