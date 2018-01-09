package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Patient;
import be.gestionhopital.Models.ListPatient;
import java.util.ArrayList;

public final class Patient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>Patients</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<h1>Gestion de la liste des patients</h1>\r\n");
      out.write("\t");

		HttpSession sess = request.getSession();
		ListPatient lp = (ListPatient) request.getAttribute("lp");
		boolean isModif = (Boolean) request.getAttribute("isModif");
		int selected = (Integer) request.getAttribute("i");
		int i = 0;
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"ServletPatient\" method=\"post\">\r\n");
      out.write("\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tNuméro du patient\r\n");
      out.write("\t\t\t\t</th>\r\n");
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
      out.write("\t\t\t\t\tNuméro de chambre\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				for(Patient p : lp.getListPatient()){
					sess.setAttribute("pati"+Integer.toString(i), p);
					if(isModif && i == selected){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numPatientModif\" name=\"numPatientModif\" value=\"");
      out.print(p.getNumPatient() );
      out.write("\" required size=\"20\" maxlength=\"5\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"nomPatientModif\" name=\"nomPatientModif\" value=\"");
      out.print(p.getNom() );
      out.write("\" required size=\"20\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"prenomPatientModif\" name=\"prenomPatientModif\" value=\"");
      out.print(p.getPrenom() );
      out.write("\" required size=\"20\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t    \t");

						    		String date = p.getDateNaiss().toString();
							    	int premierTiret = date.indexOf("-");
									int deuxiemeTiret = date.indexOf('-', premierTiret+1);
									String annee = date.substring(0,premierTiret);
									String mois = date.substring(premierTiret+1,deuxiemeTiret);
									String jour = date.substring(deuxiemeTiret+1);
						    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateNaissJModif\" name=\"dateNaissJModif\" value=\"");
      out.print(jour );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t        /\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateNaissMModif\" name=\"dateNaissMModif\" value=\"");
      out.print(mois );
      out.write("\" required size=\"3\" maxlength=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t        /\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"dateNaissAModif\" name=\"dateNaissAModif\" value=\"");
      out.print(annee );
      out.write("\" required size=\"3\" maxlength=\"4\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numTelPatientModif\" name=\"numTelPatientModif\" value=\"");
      out.print(p.getNumTelephone() );
      out.write("\" required size=\"20\" maxlength=\"20\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" id=\"numChPatientModif\" name=\"numChPatientModif\" value=\"");
      out.print(p.getNumChambre() );
      out.write("\" required size=\"20\" maxlength=\"3\" />\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td>\r\n");
      out.write("\t\t\t\t\t\t    \t<input type=\"hidden\" name=\"selected\" id=\"selected\" value=\"");
      out.print(selected );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"submit\" name=\"validModif\" id=\"validModif\" value=\"Valider\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getNumPatient() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getNom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getDateNaiss() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getNumTelephone() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(p.getNumChambre() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"pat\" name=\"pat\" value=\"");
      out.print(i );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
}
					i++;
				}
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"modif\" id=\"modif\" value=\"Modifier\"/>\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"retour\" id=\"retour\" value=\"Retour\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
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
      out.write("\t</ul>\r\n");
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
