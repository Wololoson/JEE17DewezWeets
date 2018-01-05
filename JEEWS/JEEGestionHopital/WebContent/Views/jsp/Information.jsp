<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.Personne" %>
<%@ page import="be.gestionhopital.Models.Chirurgien" %>
<%@ page import="be.gestionhopital.Models.Secretaire" %>
<%@ page import="be.gestionhopital.Models.Directeur" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Informations</title>
	</head>
	<body>
	<h1>Gestion des informations</h1>
	<%
			HttpSession sess = request.getSession();
			String type = (String) sess.getAttribute("type");
			Personne p = (Personne) sess.getAttribute(type);
			String date = p.getDateNaiss();
			int premierSlash = date.indexOf("-");
			int deuxiemeSlash = date.indexOf('-', premierSlash+1);
			String annee = date.substring(0,premierSlash);
			String mois = date.substring(premierSlash+1,deuxiemeSlash);
			String jour = date.substring(deuxiemeSlash+1);
	%>
	
		<form action="ServletInformation" method="post">
			<table cellspacing="0" cellpadding="5">
				<tr>
					<td>
						Nom :
					</td>
					<td>
						<input type="text" name="nom" id="nom" value="<%=p.getNom() %>" size="20" required="required" maxlength="50" />
					</td>
				</tr>
				<tr>
					<td>
						Pr�nom :
					</td>
					<td>
						<input type="text" name="prenom" id="prenom" value="<%=p.getPrenom() %>" size="20" required="required" maxlength="50" />
					</td>
				</tr>
				<tr>
					<td>
						Date de naissance :
					</td>
					<td>
						<input type="text" name="dateNaissJ" id="dateNaissJ" value="<%=jour %>" size="3" required="required" maxlength="2" placeholder="01" />
						<input type="text" name="dateNaissM" id="dateNaissM" value="<%=mois %>" size="3" required="required" maxlength="2" placeholder="01" />
						<input type="text" name="dateNaissA" id="dateNaissA" value="<%=annee %>" size="3" required="required" maxlength="4" placeholder="2000" />
					</td>
				</tr>
				<tr>
					<td>
						Num�ro de t�l�phone :
					</td>
					<td>
						<input type="text" name="numTel" id="numTel" value="<%=p.getNumTelephone() %>" size="20" required="required" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>
						Mot de passe :
					</td>
					<td>
						<input type="password" name="motDePasse" id="motDePasse" value="" size="20"/>
					</td>
				</tr>
				<% if(type.equals("chirurgien")){ %>
				<tr>
					<td>
						Sp�cialisation :
					</td>
					<td>
						<input type="text" name="specialisation" id="specialisation" value="<%=((Chirurgien)p).getSpecialisation() %>" size="20" required="required" maxlength="30"/>
					</td>
				</tr>
				<%}%>
				<% if(type.equals("secretaire")){ %>
				<tr>
					<td>
						Service :
					</td>
					<td>
						<input type="text" name="service" id="service" value="<%=((Secretaire)p).getService() %>" size="20" required="required" maxlength="30"/>
					</td>
				</tr>
				<%}%>
				<% if(type.equals("directeur")){ %>
				<tr>
					<td>
						Code :
					</td>
					<td>
						<input type="text" name="code" id="code" value="<%=((Directeur)p).getCode() %>" size="20" required="required" maxlength="30"/>
					</td>
				</tr>
				<%}%>
				<tr>
					<td>
						<input type="submit" name="valider" id="valider" value="Valider"/>
					</td>
					<td>
						<input type="submit" name="retour" id="retour" value="Retour"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>