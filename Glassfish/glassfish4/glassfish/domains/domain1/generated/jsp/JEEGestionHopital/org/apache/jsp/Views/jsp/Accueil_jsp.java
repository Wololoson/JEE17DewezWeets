package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Secretaire;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.Directeur;
import java.util.ArrayList;

public final class Accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Accueil</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		HttpSession sess = request.getSession();
		ArrayList<String> boutons = new ArrayList<String>();
		ArrayList<String> btnNames = new ArrayList<String>();
		ArrayList<String> servletNames = new ArrayList<String>();
		String type = (String) sess.getAttribute("type");
		if(type.equals("chirurgien")){
			
      out.write("\r\n");
      out.write("\t\t\t\t");
      be.gestionhopital.Models.Chirurgien chirurgien = null;
      synchronized (session) {
        chirurgien = (be.gestionhopital.Models.Chirurgien) _jspx_page_context.getAttribute("chirurgien", PageContext.SESSION_SCOPE);
        if (chirurgien == null){
          chirurgien = new be.gestionhopital.Models.Chirurgien();
          _jspx_page_context.setAttribute("chirurgien", chirurgien, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t\t\t");

		}
		if(type.equals("secretaire")){
			
      out.write("\r\n");
      out.write("\t\t\t\t");
      be.gestionhopital.Models.Secretaire secretaire = null;
      synchronized (session) {
        secretaire = (be.gestionhopital.Models.Secretaire) _jspx_page_context.getAttribute("secretaire", PageContext.SESSION_SCOPE);
        if (secretaire == null){
          secretaire = new be.gestionhopital.Models.Secretaire();
          _jspx_page_context.setAttribute("secretaire", secretaire, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t\t\t");

		}
		if(type.equals("directeur")){
			
      out.write("\r\n");
      out.write("\t\t\t\t");
      be.gestionhopital.Models.Directeur directeur = null;
      synchronized (session) {
        directeur = (be.gestionhopital.Models.Directeur) _jspx_page_context.getAttribute("directeur", PageContext.SESSION_SCOPE);
        if (directeur == null){
          directeur = new be.gestionhopital.Models.Directeur();
          _jspx_page_context.setAttribute("directeur", directeur, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t\t\t");

		}
	
      out.write("\r\n");
      out.write("\t<h1>Accueil</h1>\r\n");
      out.write("\t");

		if(type.equals("chirurgien")){ 
			
      out.write("\r\n");
      out.write("\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\tBienvenue ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Chirurgien)_jspx_page_context.findAttribute("chirurgien")).getNom())));
      out.write(' ');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Chirurgien)_jspx_page_context.findAttribute("chirurgien")).getPrenom())));
      out.write("\r\n");
      out.write("\t\t\t\t</h2>\r\n");
      out.write("\t\t\t");

				boutons.add("Gérer les réservations");
				boutons.add("Gérer les notifications");
				boutons.add("Gérer les informations");
				
				btnNames.add("chirRes");
				btnNames.add("chirNoti");
				btnNames.add("chirInfo");
				
				servletNames.add("ServletReservation");
				servletNames.add("ServletNotification");
				servletNames.add("ServletInformation");
		}
		if(type.equals("secretaire")){
			
      out.write("\r\n");
      out.write("\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\tBienvenue ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Secretaire)_jspx_page_context.findAttribute("secretaire")).getNom())));
      out.write(' ');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Secretaire)_jspx_page_context.findAttribute("secretaire")).getPrenom())));
      out.write("\r\n");
      out.write("\t\t\t\t</h2>\r\n");
      out.write("\t\t\t");

				boutons.add("Gérer les réservations");
				boutons.add("Consulter la liste des patients");
				boutons.add("Gérer les informations");
				
				btnNames.add("secrRes");
				btnNames.add("secrPati");
				btnNames.add("secrInfo");
				
				servletNames.add("ServletReservation");
				servletNames.add("ServletPatient");
				servletNames.add("ServletInformation");
		}
		if(type.equals("directeur")){
			
      out.write("\r\n");
      out.write("\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\tBienvenue ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Directeur)_jspx_page_context.findAttribute("directeur")).getNom())));
      out.write(' ');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((be.gestionhopital.Models.Directeur)_jspx_page_context.findAttribute("directeur")).getPrenom())));
      out.write("\r\n");
      out.write("\t\t\t\t</h2>\r\n");
      out.write("\t\t\t");

				boutons.add("Gérer les réservations");
				boutons.add("Consulter la liste des patients");
				boutons.add("Gérer le personnel");
				boutons.add("Gérer les informations");
				
				btnNames.add("direRes");
				btnNames.add("direPati");
				btnNames.add("direPers");
				btnNames.add("direInfo");
				
				servletNames.add("ServletReservation");
				servletNames.add("ServletPatient");
				servletNames.add("ServletPersonnel");
				servletNames.add("ServletInformation");
		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"ServletAccueil\" method=\"post\">\r\n");
      out.write("\t\t<input id=\"");
      out.print(btnNames.get(0) );
      out.write("\" name=\"");
      out.print(btnNames.get(0) );
      out.write("\" value=\"");
      out.print(boutons.get(0) );
      out.write("\" type=\"submit\"/>\r\n");
      out.write("\t\t<input id=\"");
      out.print(btnNames.get(1) );
      out.write("\" name=\"");
      out.print(btnNames.get(1) );
      out.write("\" value=\"");
      out.print(boutons.get(1) );
      out.write("\" type=\"submit\"/>\r\n");
      out.write("\t\t<input id=\"");
      out.print(btnNames.get(2) );
      out.write("\" name=\"");
      out.print(btnNames.get(2) );
      out.write("\" value=\"");
      out.print(boutons.get(2) );
      out.write("\" type=\"submit\"/>\r\n");
      out.write("\t\t");
 if(type.equals("directeur")){ 
      out.write("\r\n");
      out.write("\t\t\t<input id=\"");
      out.print(btnNames.get(3) );
      out.write("\" name=\"");
      out.print(btnNames.get(3) );
      out.write("\" value=\"");
      out.print(boutons.get(3) );
      out.write("\" type=\"submit\"/>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t</form>\r\n");
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
