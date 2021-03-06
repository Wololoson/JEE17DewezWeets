<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.Personne" %>
<%@ page import="be.gestionhopital.Models.Secretaire" %>
<%@ page import="be.gestionhopital.Models.Chirurgien" %>
<%@ page import="be.gestionhopital.Models.Directeur" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<%
		HttpSession sess = request.getSession();
		ArrayList<String> boutons = new ArrayList<String>();
		ArrayList<String> btnNames = new ArrayList<String>();
		String type = (String) sess.getAttribute("type");
		if(type.equals("chirurgien")){
			%>
				<jsp:useBean id="chirurgien" class="be.gestionhopital.Models.Chirurgien" scope="session"/>
			<%
		}
		if(type.equals("secretaire")){
			%>
				<jsp:useBean id="secretaire" class="be.gestionhopital.Models.Secretaire" scope="session"/>
			<%
		}
		if(type.equals("directeur")){
			%>
				<jsp:useBean id="directeur" class="be.gestionhopital.Models.Directeur" scope="session"/>
			<%
		}
	%>
	<h1>Accueil</h1>
	<%
		if(type.equals("chirurgien")){ 
			%>
				<h2>
					Bienvenue <jsp:getProperty property="nom" name="chirurgien"/> <jsp:getProperty property="prenom" name="chirurgien"/>
				</h2>
			<%
				boutons.add("G�rer les r�servations");
				boutons.add("G�rer les notifications");
				boutons.add("G�rer les informations");
				
				btnNames.add("chirRes");
				btnNames.add("chirNoti");
				btnNames.add("chirInfo");
		}
		if(type.equals("secretaire")){
			%>
				<h2>
					Bienvenue <jsp:getProperty property="nom" name="secretaire"/> <jsp:getProperty property="prenom" name="secretaire"/>
				</h2>
			<%
				boutons.add("G�rer les r�servations");
				boutons.add("Consulter la liste des patients");
				boutons.add("G�rer les informations");
				
				btnNames.add("secrRes");
				btnNames.add("secrPati");
				btnNames.add("secrInfo");
		}
		if(type.equals("directeur")){
			%>
				<h2>
					Bienvenue <jsp:getProperty property="nom" name="directeur"/> <jsp:getProperty property="prenom" name="directeur"/>
				</h2>
			<%
				boutons.add("G�rer les r�servations");
				boutons.add("Consulter la liste des patients");
				boutons.add("G�rer le personnel");
				
				btnNames.add("direRes");
				btnNames.add("direPati");
				btnNames.add("direPers");
		}
		
		boutons.add("Se d�connecter");
		btnNames.add("leave");
	%>
	
	<form action="ServletAccueil" method="post">
		<input id="<%=btnNames.get(0) %>" name="<%=btnNames.get(0) %>" value="<%=boutons.get(0) %>" type="submit"/>
		<input id="<%=btnNames.get(1) %>" name="<%=btnNames.get(1) %>" value="<%=boutons.get(1) %>" type="submit"/>
		<input id="<%=btnNames.get(2) %>" name="<%=btnNames.get(2) %>" value="<%=boutons.get(2) %>" type="submit"/>
		<input id="<%=btnNames.get(3) %>" name="<%=btnNames.get(3) %>" value="<%=boutons.get(3) %>" type="submit"/>
	</form>
</body>
</html>