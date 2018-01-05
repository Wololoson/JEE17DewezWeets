<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.Personne" %>
<%@ page import="be.gestionhopital.Models.Chirurgien" %>
<%@ page import="be.gestionhopital.Models.Secretaire" %>
<%@ page import="be.gestionhopital.Models.ListPersonnel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Personnel</title>
	</head>
	<body>
	<h1>Gestion du personnel</h1>
	<%
		HttpSession sess = request.getSession();
		String type = (String) sess.getAttribute("type");
		Personne p = (Personne) sess.getAttribute(type);
		ListPersonnel lp = (ListPersonnel) request.getAttribute("lp");
		int i = 0;
	%>
	
	<form action="ServletPersonnel" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th colspan="6">
					Chirurgien
				</th>
			</tr>
			<tr>
				<th>
					Nom
				</th>
				<th>
					Pr�nom
				</th>
				<th>
					Date de naissance
				</th>
				<th>
					Num�ro de t�l�phone
				</th>
				<th>
					Sp�cialisation
				</th>
				<td>
				</td>
			</tr>
			<%
				for(Chirurgien c : lp.getListChirurgien()){%>
					<tr>
						<td>
							<%=c.getNom() %>
						</td>
						<td>
							<%=c.getPrenom() %>
						</td>
						<td>
							<%=c.getDateNaiss() %>
						</td>
						<td>
							<%=c.getNumTelephone() %>
						</td>
						<td>
							<%=c.getSpecialisation() %>
						</td>
						<td>
							<input type="radio" id="pat" name="pat" value="<%=i %>"/>
						</td>
					</tr>
					<%i++;
				}%>
				<tr>
				<th colspan="6">
					Secretaire
				</th>
				</tr>
				<tr>
					<th>
						Nom
					</th>
					<th>
						Pr�nom
					</th>
					<th>
						Date de naissance
					</th>
					<th>
						Num�ro de t�l�phone
					</th>
					<th>
						Service
					</th>
					<td>
					</td>
				</tr>
				<%
				for(Secretaire s : lp.getListSecretaire()){%>
					<tr>
						<td>
							<%=s.getNom() %>
						</td>
						<td>
							<%=s.getPrenom() %>
						</td>
						<td>
							<%=s.getDateNaiss() %>
						</td>
						<td>
							<%=s.getNumTelephone() %>
						</td>
						<td>
							<%=s.getService() %>
						</td>
						<td>
							<input type="radio" id="pat" name="pat" value="<%=i %>"/>
						</td>
					</tr>
					<%i++;
				}%>
			</table>
			<input type="submit" name="ajout" id="ajout" value="Ajouter"/>
			<input type="submit" name="modif" id="modif" value="Modifier"/>
			<input type="submit" name="suppr" id="suppr" value="Supprimer"/>
			<input type="submit" name="retour" id="retour" value="Retour"/>
		</form>
	</body>
</html>