<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.ListPersonnel" %>
<%@ page import="be.gestionhopital.Models.Secretaire" %>
<%@ page import="be.gestionhopital.Models.Chirurgien" %>
<%@ page import="be.gestionhopital.Models.Directeur" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
<script type="text/javascript">
	function direCodeDisplay(i){
		var direCode = document.getElementById("direCode");
		
		if(i == 0)
			direCode.style.display = "none";
		else
			direCode.style.display = "table-row";
	}
</script>
</head>
<body>
	<%
		ListPersonnel lp = ListPersonnel.getInstance();
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
	%>
	<h1>Connexion</h1>
	<form action="ServletConnexion" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td>Identifiant :</td>
				<td>
					<select id="listPers" name="listPers">
						<% 
						for(Chirurgien c : lp.getListChirurgien()){%>
							<option value="<%=c.getIdPersonne()%>" onclick="direCodeDisplay(0)"><%=c.getNom()%> <%=c.getPrenom()%></option>
						<%
						}
						for(Secretaire s : lp.getListSecretaire()){%>
							<option value="<%=s.getIdPersonne()%>" onclick="direCodeDisplay(0)"><%=s.getNom()%> <%=s.getPrenom()%></option>
						<%
						}
						%>
						<option value="dire" onclick="direCodeDisplay(1)"><%=lp.getDirecteur().getNom() %> <%=lp.getDirecteur().getPrenom() %></option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type="password" name="motDePasse" id="motDePasse" value="" size="20"/></td>
			</tr>
			<tr id="direCode" style="display: none">
				<td>Code :</td>
				<td><input type="password" name="code" id="code" value="" size="20" maxlength="4"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="center"><input type="submit" name="connect" id="connect" value="Se connecter"/></td>
			</tr>
		</table>
	</form>
	<ul style="color:RED">
		<%
			if(erreurs != null){
				for (String s : erreurs) {
		%>
				<li>
					<%=s %>
				</li>
		<%	
				}
			}
		%>
	</ul>
</body>
</html>