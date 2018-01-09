package org.apache.jsp.Views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import be.gestionhopital.Models.Personne;
import be.gestionhopital.Models.Notification;
import be.gestionhopital.Models.ListNotification;

public final class Notification_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>Notifications</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<h1>Gestion des notifications</h1>\r\n");
      out.write("\t");

		HttpSession sess = request.getSession();
		String type = (String) sess.getAttribute("type");
		Personne p = (Personne) sess.getAttribute(type);
		ListNotification ln = (ListNotification) request.getAttribute("ln");
		int i = 0;
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"ServletNotification\" method=\"post\">\r\n");
      out.write("\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tPriorité\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tType de réservation\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\tCommentaire\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				for(Notification n : ln.getListNotification()){
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");
 if(p.equals(n.getChirurgien())){
					sess.setAttribute("noti"+Integer.toString(i), n);
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(n.getPriorite() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t");
 switch(n.getType()){
						case 1:
							
      out.write("Ajout");

							break;
						case 2:
							
      out.write("Modification");

							break;
						case 3:
							
      out.write("Suppression");

							break;
						}
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(n.getCommentaire() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" id=\"noti\" name=\"noti\" value=\"");
      out.print(i);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				i++;
				} 
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"suppr\" id=\"suppr\" value=\"Supprimer\"/>\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"supprAll\" id=\"supprAll\" value=\"Tout supprimer\"/>\r\n");
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
